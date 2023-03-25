import java.util.*;
class Point{
    double x;
    double y;
    Point(double x,double y){
        this.x = x;
        this.y = y;
    }
    double getX(){
        return x;
    }
    double getY(){
        return y;
    }
}

public class MyClass {
    public static boolean isRectangle(Set<Point> points) {
    if (points.size() != 4) {
        // A rectangle must have exactly 4 points
        return false;
    }
    // Convert the set of points to a list for easier access
    List<Point> pointList = new ArrayList<>(points);

    // Find the min and max X and Y coordinates
    double minX = Double.POSITIVE_INFINITY;
    double minY = Double.POSITIVE_INFINITY;
    double maxX = Double.NEGATIVE_INFINITY;
    double maxY = Double.NEGATIVE_INFINITY;
    int imi = 0, ima = 0;
    for (int i = 0; i < pointList.size(); i++) {
        Point point = pointList.get(i);
        double x = point.getX();
        double y = point.getY();
        if (x < minX) {
            minX = x;
        }
        if (x > maxX) {
            maxX = x;
        }
        if (y < minY) {
            minY = y;
        }
        if (y > maxY) {
            maxY = y;
        }
        if(x == minX && y == minY)
        {
            imi = i;
        }
        if(x == maxX && y == maxY)
        {
            ima = i;
        }
    }

    boolean ok1 = false, ok2 = false;
    for (int i = 0; i < pointList.size(); i++) {
        
        if(i != imi && i != ima)
        {
            Point p1 = pointList.get(i);
            if(p1.getX() == pointList.get(imi).getX() && p1.getY() == pointList.get(ima).getY())
            {
                ok1 = true;
            }
            if(p1.getX() == pointList.get(ima).getX() && p1.getY() == pointList.get(imi).getY())
            {
                ok2 = true;
            }
        }
        
    }
    if(ok1 == false || ok2 == false)
    return false;

    // If all tests passed, the points form a rectangle
    return true;
}
    
    public static int countRectangles(List<Point> points) {
        // Create a set of all unique points
        Set<Point> pointSet = new HashSet<>(points);
        Set<Set<Point>> pss = new HashSet<>();
       for(Point p1 : pointSet)
       {

           for(Point p2 : pointSet)
       {
           
           for(Point p3 : pointSet)
       {
           
           for(Point p4 : pointSet)
       {
           
           Set<Point> ps2 = new HashSet<>();
           ps2.add(p1);
           ps2.add(p2);
           ps2.add(p3);
           ps2.add(p4);
           
           if(isRectangle(ps2) == true)
          pss.add(ps2);
       }
       }
       }
       }
        

        
        return pss.size(); 
    }
    public static void main(String args[]) {
    List<Point> lp = new ArrayList();
    
    Point p = new Point(1.0, 1.0);
    lp.add(p);
    Point p2 = new Point(1.0, 3.0);
    lp.add(p2);
    Point p3 = new Point(2.0, 1.0);
    lp.add(p3);
    Point p4 = new Point(2.0, 3.0);
    lp.add(p4);
    Point p5 = new Point(3.0, 1.0);
    lp.add(p5);
    Point p6 = new Point(3.0, 3.0);
    lp.add(p6);
      System.out.println("Count = " + countRectangles(lp));
    }
}