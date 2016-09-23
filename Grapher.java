package grapher;

import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.scene.shape.LineTo;
import javafx.scene.shape.MoveTo;
import javafx.scene.shape.Path;
import javafx.stage.Stage;

public class Grapher extends Application {


    
    @Override
    public void start(Stage primaryStage){
        // graph y = 2x^3 - 3x^2 + 5x + 7 on [-200, 200]
        
        int yScale = 1;
        int xScale = 20;
        
        double xMin = -5;
        double xMax = 10;
        
        int xOff = 200;
        int yOff = 200;
        double xStep = 0.1;
        
        Pane pane = new Pane();
        
        Path line = new Path();
        MoveTo startPoint = new MoveTo(xMin * xScale + xOff, (f(xMin) * yScale)+ yOff);
        line.getElements().add(startPoint);
       
        for (double x = xMin; x < xMax; x += xStep){
            line.getElements().add(new LineTo(x * xScale + xOff, (f(x) * yScale) + yOff));
        }
        
        Path xAxis = new Path();
        MoveTo xLeftEnd = new MoveTo((xMin + xOff) * -xScale, yOff);
        LineTo xRightEnd = new LineTo ((xMax + xOff) * xScale, yOff);
        xAxis.getElements().addAll(xLeftEnd, xRightEnd);
        
        Path yAxis = new Path();
        MoveTo yLeftEnd = new MoveTo(xMax * xScale, 0);
        LineTo yRightEnd = new LineTo(xMax * xScale, yOff * 2 * yScale);
        yAxis.getElements().addAll(yLeftEnd, yRightEnd);
               
        pane.getChildren().addAll(line, xAxis, yAxis);
        
        Scene scene = new Scene(pane);
        primaryStage.setScene(scene);
        primaryStage.setWidth(xMax * xScale * 2);
        primaryStage.setHeight(yOff * 2 * yScale);
        primaryStage.setTitle("Girapher");
        primaryStage.show();
    }

    public static void main(String[] args) {
        launch();
    }
    
    public static double f(double x){
        double y = (2 * Math.pow(x, 3)) - (3 * Math.pow(x, 2)) + (5 * x) + 7;
        //double y = x;
        return -y;
    }

}
