package othello.view;

import java.awt.Component;
import java.awt.Container;
import java.awt.Dimension;
import java.awt.LayoutManager;
import java.util.HashMap;
import java.util.Map;

public class ProportionalLayout implements LayoutManager {

    private Map<Component, Float[]> componentConstraints = new HashMap<>();
    private static final float PADDING_PERCENTAGE = 0.1f; // 10% padding

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


        int paddingX = Math.round(width * PADDING_PERCENTAGE);
        int paddingY = Math.round(height * PADDING_PERCENTAGE);

        int adjustedWidth = width - 2 * paddingX;
        int adjustedHeight = height - 2 * paddingY;

        int size = Math.min(adjustedWidth, adjustedHeight);

        int xOffset = paddingX + (adjustedWidth - size) / 2;
        int yOffset = paddingY + (adjustedHeight - size) / 2;

        for (Map.Entry<Component, Float[]> entry : componentConstraints.entrySet()) {
            Component comp = entry.getKey();
            Float[] constraints = entry.getValue();
            int x = xOffset + Math.round(constraints[0] * size);
            int y = yOffset + Math.round(constraints[1] * size);
            int w = Math.round(constraints[2] * size);
            int h = Math.round(constraints[3] * size);
            comp.setBounds(x, y, w, h);
        }
    }
}
