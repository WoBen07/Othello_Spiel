package othello.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

public class ProportionalLayout implements LayoutManager {

    private Map<Component, Float[]> componentConstraints = new HashMap<>();


    @Override
    public void addLayoutComponent(String name, Component comp) { }

    public void addLayoutComponent(Component comp, Float x, Float y, Float width, Float height) {
        componentConstraints.put(comp, new Float[]{x, y, width, height});
    }

    @Override
    public void removeLayoutComponent(Component comp) {
        componentConstraints.remove(comp);
    }

    @Override
    public Dimension preferredLayoutSize(Container parent) {
        return new Dimension(500, 500);
    }

    @Override
    public Dimension minimumLayoutSize(Container parent) {
        return new Dimension(100, 100);
    }

    @Override
    public void layoutContainer(Container parent) {

        int width = parent.getWidth();
        int height = parent.getHeight();

        for (Map.Entry<Component, Float[]> entry : componentConstraints.entrySet()) {
            Component comp = entry.getKey();
            Float[] constraints = entry.getValue();
            int x = Math.round(constraints[0] * width);
            int y = Math.round(constraints[1] * height);
            int w = Math.round(constraints[2] * width);
            int h = Math.round(constraints[3] * height);
            comp.setBounds(x, y, w, h);
        }
    }


}
