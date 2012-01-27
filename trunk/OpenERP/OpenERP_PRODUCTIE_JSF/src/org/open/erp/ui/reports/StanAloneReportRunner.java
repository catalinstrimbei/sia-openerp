package org.open.erp.ui.reports;

import java.io.File;
import java.io.FileInputStream;
import java.io.InputStream;

/*import org.eclipse.birt.core.framework.Platform;
import org.eclipse.birt.report.engine.api.EngineConfig;
import org.eclipse.birt.report.engine.api.EngineException;
import org.eclipse.birt.report.engine.api.IRenderTask;
import org.eclipse.birt.report.engine.api.IReportDocument;
import org.eclipse.birt.report.engine.api.IReportEngine;
import org.eclipse.birt.report.engine.api.IReportEngineFactory;
import org.eclipse.birt.report.engine.api.IReportRunnable;
import org.eclipse.birt.report.engine.api.IRunAndRenderTask;
import org.eclipse.birt.report.engine.api.RenderOption;*/

public class StanAloneReportRunner {/*

	public static void main(String[] args) {
		/* Classpath testing *//* 
		String appPath = new File(ClassLoader.getSystemClassLoader()
				.getResource("").getPath()).getPath();
		String reportPath = appPath + "/org/comenzi/reports";
		System.out.println(reportPath);

		// Create an EngineConfig object.
		EngineConfig config = new EngineConfig();
		// Set up the path to your BIRT home directory.
		//config.setBIRTHome("E:/Professional/Programare_OO/Projects/Exemple_WKS/libraries/BIRTReportEngine");
		//config.setBIRTHome(appPath);

		// Start the platform for a non-RCP application.
		try {
			/* Start Report Engine *//* 
			Platform.startup(config);
			IReportEngineFactory factory = (IReportEngineFactory) Platform
					.createFactoryObject(IReportEngineFactory.EXTENSION_REPORT_ENGINE_FACTORY);
			// Set up writing images or charts embedded in HTML output.
			//HTMLRenderOption ho = new HTMLRenderOption();
			//ho.setImageHandler(new HTMLCompleteImageHandler());
			//config.setEmitterConfiguration(RenderOption.OUTPUT_FORMAT_HTML, ho);
			// Create the engine.
			IReportEngine engine = factory.createReportEngine(config);
			System.out.println("Started BIRT Report Engine ...");

			/* Open report design *//* 
			String designName = reportPath + "/ReportClienti.rptdesign";
			IReportRunnable runnable = null;
			try {
				runnable = engine.openReportDesign(designName);
			} catch (EngineException e) {
				System.err.println("Design " + designName + " not found!");
				engine.destroy();
				System.exit(-1);
			}
			// Get the value of a simple property.
			String title = (String) runnable.getProperty(IReportRunnable.TITLE);
			System.out.println("Open Report Design entitled " + title);

			/* Generate report from design *//* 
			// Create a run and render task object.
			IRunAndRenderTask task = engine.createRunAndRenderTask(runnable);
			// Set PDF Format
			String outputName = reportPath + "/ReportClienti.pdf";
			//PDFRenderOption pdfRenderOptions = new PDFRenderOption();
			//pdfRenderOptions.setOutputFileName(outputName);
			// General options
			RenderOption ro = new RenderOption();
			ro.setOutputFormat(RenderOption.OUTPUT_FORMAT_PDF);
			ro.setOutputFileName(outputName);
			// Apply the rendering options to the task.
			task.setRenderOption(ro);
			// Generate
			try {
				task.run();
				System.out.println("Created Report " + outputName + ".");
				task.close();
				
				// and render
				FileInputStream doc = new FileInputStream(outputName);
				System.out.println("Accessed Report Doc " + doc.getFD() + ".");
				
				//IReportDocument binaryDoc = engine.openReportDocument("/org/comenzi/reports/ReportClienti.pdf");
				// Create a render task object. ???
				//IRenderTask taskRender = engine.createRenderTask( binaryDoc );
				//System.out.println("Accessed Report Doc " + outputName + ".");
			} catch (EngineException ex) {
				System.err.println("Report " + outputName + " run failed.");
				System.err.println(ex.toString());
				ex.printStackTrace();
			}

		} catch (Exception e) {
			e.printStackTrace();
		}
	}*/
}
