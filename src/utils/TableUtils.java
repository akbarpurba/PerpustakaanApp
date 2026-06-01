/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package utils;

import java.awt.Color;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.Font;
import javax.swing.BorderFactory;
import javax.swing.JTable;
import javax.swing.SwingConstants;
import javax.swing.table.DefaultTableCellRenderer;
import javax.swing.table.JTableHeader;

/**
 *
 * @author Acer
 */
public class TableUtils {

      public static void setTableStyle(JTable table) {

        Color headerBackground = new Color(59, 130, 246);
        Color headerForeground = Color.WHITE;

        Color rowColor1 = Color.WHITE;
        Color rowColor2 = new Color(248, 250, 252);

        Color selectionColor = new Color(219, 234, 254);

        Color gridColor = new Color(230, 230, 230);

        DefaultTableCellRenderer bodyRenderer =
                new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                Component c = super.getTableCellRendererComponent(
                        table,
                        value,
                        isSelected,
                        hasFocus,
                        row,
                        column
                );

                setHorizontalAlignment(SwingConstants.CENTER);

                c.setFont(new Font("Segoe UI", Font.PLAIN, 13));

                if (isSelected) {

                    c.setBackground(selectionColor);
                    c.setForeground(Color.BLACK);

                } else {

                    if (row % 2 == 0) {
                        c.setBackground(rowColor1);
                    } else {
                        c.setBackground(rowColor2);
                    }

                    c.setForeground(Color.BLACK);
                }

                setBorder(BorderFactory.createMatteBorder(0, 0, 1, 0, new Color(230, 230,  230)));
                return c;
            }
        };

        table.setDefaultRenderer(Object.class, bodyRenderer);

        JTableHeader header = table.getTableHeader();
        header.setOpaque(false);
        header.setBackground(headerBackground);
        header.setForeground(headerForeground);
        

        header.setDefaultRenderer(new DefaultTableCellRenderer() {

            @Override
            public Component getTableCellRendererComponent(
                    JTable table,
                    Object value,
                    boolean isSelected,
                    boolean hasFocus,
                    int row,
                    int column) {

                Component c = super.getTableCellRendererComponent(
                        table,
                        value,
                        isSelected,
                        hasFocus,
                        row,
                        column
                );

                if(c instanceof javax.swing.JLabel label){
                    label.setOpaque(true);
                }
                
                c.setBackground(headerBackground);
                c.setForeground(headerForeground);

                c.setFont(new Font("Segoe UI", Font.BOLD, 14));

                setHorizontalAlignment(SwingConstants.CENTER);

                setBorder(BorderFactory.createEmptyBorder(8, 8, 8, 8));

                return c;
            }
        });

        table.setRowHeight(34);

        table.setShowGrid(false);

        table.setIntercellSpacing(new Dimension(0, 0));

        table.setSelectionBackground(selectionColor);
        table.setSelectionForeground(Color.BLACK);

        table.setBackground(Color.WHITE);

        table.setFocusable(false);

        header.setPreferredSize(new Dimension(
                header.getWidth(),
                40
        ));

        header.setBorder(BorderFactory.createEmptyBorder());
    }
}
