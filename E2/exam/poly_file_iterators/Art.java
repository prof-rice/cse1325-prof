import java.io.BufferedReader;
import java.io.FileReader;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;

import java.util.Set;
import java.util.HashSet;

import java.util.Iterator;

public class Art {
    public void addShape(Shape shape) {
        this.shapes.add(shape);
    }
    public void writeFigures(String filename) {
        try(BufferedWriter bw = new BufferedWriter(new FileWriter(filename))) {
            bw.write("" + shapes.size() + '\n');
            for(Shape shape : shapes) {
                bw.write(shape.getClass().getName() + '\n');
                shape.save(bw);
            }
        } catch(Exception e) {
            System.err.println("Unable to save shapes: " + e);
        }
    }
    public void readFigures(String filename) {
        try(BufferedReader br = new BufferedReader(new FileReader(filename))) {
            int size = Integer.parseInt(br.readLine());
            while(size-- > 0) {
                String shapeType = br.readLine();
                shapes.add((Shape) Class.forName(shapeType)
                                        .getConstructor(BufferedReader.class)
                                        .newInstance(br));
            }
        } catch(Exception e) {
            System.err.println("Unable to save shapes: " + e);
        }
    }
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        Iterator<Shape> it = shapes.iterator();
        while(it.hasNext()) {
            sb.append(it.next().toString() + '\n');
        }
        return sb.toString();
    }

    Set<Shape> shapes = new HashSet<>();
}
