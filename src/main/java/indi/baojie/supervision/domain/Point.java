package indi.baojie.supervision.domain;

/**
 * Created by lollipop on 17/9/19
 */
public class Point {
    private Integer id;

    private String name;

    private Double pointX;

    private Double pointY;

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Double getPointX() {
        return pointX;
    }

    public void setPointX(Double pointX) {
        this.pointX = pointX;
    }

    public Double getPointY() {
        return pointY;
    }

    public void setPointY(Double pointY) {
        this.pointY = pointY;
    }

    @Override
    public String toString() {
        return "Point{" +
                "id=" + id +
                ", name='" + name + '\'' +
                ", pointX=" + pointX +
                ", pointY=" + pointY +
                '}';
    }
}
