package org.open.erp.ui.reports;

import java.io.File;
import java.io.FileInputStream;

import javax.faces.context.FacesContext;
import javax.servlet.ServletContext;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServletResponse;

import org.eclipse.birt.core.framework.IPlatformContext;
import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.core.framework.PlatformServletContext;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;

import com.sun.xml.internal.messaging.saaj.util.ByteInputStream;


public class WebReportRunner {
	
	public static void runReport(String reportName) {
		/* Classpath */
		//String reportPath = "./";
		FacesContext faces = FacesContext.getCurrentInstance();
		ServletContext servletContext = (ServletContext) 
				FacesContext.getCurrentInstance().getExternalContext().getContext();		
		
		System.out.println("servletContext.getContextPath()=" + servletContext.getContextPath());
		System.out.println("servletContext.getRealPath()=" + servletContext.getRealPath(""));
		String reportPath = servletContext.getRealPath("") + "/";
		
		/* Create an EngineConfig object. */
		EngineConfig config = new EngineConfig();
		// Start the platform for a non-RCP application.
		try {
			/* Start Report Engine */
			config.setBIRTHome("");
			//config.setBIRTHome("E:/Professional/Programare_OO/Projects/Exemple_WKS/libraries/BIRTReportEngine");
			IPlatformContext context = new PlatformServletContext(servletContext);
			config.setPlatformContext(context);
			Platform.startup(config);
			IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			IReportEngine engine = factory.createReportEngine(config);
			
			/* Open report design */
			String designName = reportPath + reportName;
			IReportRunnable runnable = engine.openReportDesign(designName);

			/* Generate report from design */
			// Create a run and render task object.
			IRunAndRenderTask task = engine.createRunAndRenderTask(runnable);
			// Set PDF Format
			String outputName = reportPath + "ReportClienti.pdf";
			// PDF Render option
			RenderOption ro = new RenderOption();
			ro.setOutputFormat(RenderOption.OUTPUT_FORMAT_PDF);
			ro.setOutputFileName(outputName);
			// Apply the rendering options to the task.
			task.setRenderOption(ro);
			// Generate
			task.run();
			System.out.println("Created Report " + outputName + ".");
			task.close();

			/* Render as PDF */
			// read PDF generate
			File pdfFile = new File(outputName);
			FileInputStream doc = new FileInputStream(pdfFile);
			byte[] pdf = new byte[(int) pdfFile.length()]; 
			doc.read(pdf);
			// Prepare HTTP response
			HttpServletResponse response = (HttpServletResponse) faces.getExternalContext().getResponse();
			response.setContentLength(pdf.length);
			response.setHeader("Content-disposition", "inline;filename=" + reportName);
			ServletOutputStream out = response.getOutputStream();
			// Add generated PDF to response
			out.write(pdf);
			faces.responseComplete();
			System.out.println("Delivered Report " + outputName + ".");
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}