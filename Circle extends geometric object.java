public class Circle extends GeometricObject implements Comparable<circle> {

    private double radius;

    public Circle(double radius) {

        this.radius = radius;
    }

    publc double getRadius() {
        
        return radius;
    
}

@override
public boolean equals(Object obj) {

    if(this == obj) return true;

    if (obj == null || getClass() != obj.getClass()) return false;
    Circle circle = (Circle) obj;
    return Double.compare(circle.radius, radius) == 0;
}

@Override
public int compareTo(Circle other) {
    return Double.compare(this.radius, other.radius);
}

@Override
public String toString() {
    return "Circle with radius: " + radius;
}
}