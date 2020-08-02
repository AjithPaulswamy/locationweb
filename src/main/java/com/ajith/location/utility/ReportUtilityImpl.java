package com.ajith.location.utility;

import java.io.File;
import java.io.IOException;
import java.util.List;

import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartRenderingInfo;
import org.jfree.chart.ChartUtilities;
import org.jfree.chart.JFreeChart;
import org.jfree.data.general.DefaultPieDataset;
import org.springframework.stereotype.Component;

@Component
public class ReportUtilityImpl implements ReportUtility {

	@Override
	public void generatePieChart(String path, List<Object[]> chartData) {
		
		DefaultPieDataset dataSet=new DefaultPieDataset();
		
		for (Object[] locations : chartData) {
			dataSet.setValue(locations[0].toString(), new Double(locations[1].toString()));
		}
		
		JFreeChart chart=ChartFactory.createPieChart3D("Location Chart", dataSet);
		try {
			ChartUtilities.saveChartAsJPEG(new File(path+"/chart.jpeg"), chart, 500, 500,  new ChartRenderingInfo());
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
