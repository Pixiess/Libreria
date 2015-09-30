package controlador;


import org.jfree.chart.ChartFactory;
import org.jfree.chart.ChartPanel;
import org.jfree.chart.JFreeChart;
import org.jfree.chart.plot.PlotOrientation;
import org.jfree.chart.plot.XYPlot;
import org.jfree.chart.renderer.xy.XYLineAndShapeRenderer;
import org.jfree.data.category.DefaultCategoryDataset;
import org.jfree.data.xy.XYSeries;
import org.jfree.data.xy.XYSeriesCollection;

public class CrearGrafico 
{
    
    public static ChartPanel generarGraficoBarras(double [] tabla, String tipo)
    {
        int n = tabla.length;
        
        String [] meses = {"Enero", "Febrero", "Marzo", "Abril", "Mayo", "Junio", "Julio", "Agosto", "Septiembre", "Octubre","Noviembre", "Diciembre"};
        DefaultCategoryDataset dataset = new DefaultCategoryDataset();
        for(int i=0; i<n; i++)
            dataset.setValue(new Double(""+tabla[i]),  meses[i], "");
        
        JFreeChart chart;
        chart = ChartFactory.createBarChart3D( "", "Meses", tipo, dataset, PlotOrientation.VERTICAL, true, true, false );

        ChartPanel panel = new ChartPanel(chart);
        return panel;
    }
    
    public static ChartPanel generarGraficoDobleEje(int [][] tabla, String [] tituloLibro)
    {
        int n = tituloLibro.length;
        
        XYSeries [] series = new XYSeries[n];
        for(int i = 0; i<n; i++)
            series[i] = new XYSeries(tituloLibro[i]);
        
        for(int i=1; i<13; i++)
        {
            for(int j = 0; j<n; j++)
            {
                series[j].add(i, tabla[j][i-1]);
            }
        }
         
        XYSeriesCollection dataset = new XYSeriesCollection();
        
        for(int i = 0; i<n; i++)
            dataset.addSeries(series[i]);
         

        JFreeChart chart = ChartFactory.createXYLineChart("","Meses","Valores",dataset,PlotOrientation.VERTICAL, true, true, false);
        
        XYPlot plot = (XYPlot) chart.getPlot();
        XYLineAndShapeRenderer renderer = new XYLineAndShapeRenderer();
        
        for(int i = 0; i<n; i++)
        {
            renderer.setSeriesLinesVisible(0, true);
            renderer.setSeriesShapesVisible(0, true);   
        }

        
        plot.setRenderer(renderer);
        
        ChartPanel panel = new ChartPanel(chart);
        return panel;   
    }
}
