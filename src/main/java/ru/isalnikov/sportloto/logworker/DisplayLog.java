package ru.isalnikov.sportloto.logworker;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.beans.PropertyChangeEvent;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.util.List;
import javax.swing.JFrame;
import javax.swing.JProgressBar;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.SwingWorker;
import javax.swing.table.DefaultTableModel;
import javax.swing.table.TableModel;

/**
 * @see https://stackoverflow.com/a/25526869/230513
 */
public class DisplayLog {

    private static final String NAME = "/var/log/jetty/info.log";

    private static class LogWorker extends SwingWorker<TableModel, String> {

        private final File file;
        private final DefaultTableModel model;

        private LogWorker(File file, DefaultTableModel model) {
            this.file = file;
            this.model = model;
            model.setColumnIdentifiers(new Object[]{file.getAbsolutePath()});
        }

        @Override
        protected TableModel doInBackground() throws Exception {
            BufferedReader br = new BufferedReader(new FileReader(file));
            String s;
            while ((s = br.readLine()) != null) {
                publish(s);
            }
            return model;
        }

        @Override
        protected void process(List<String> chunks) {
            for (String s : chunks) {
                model.addRow(new Object[]{s});
            }
        }
    }

    private void display() {
        JFrame f = new JFrame("DisplayLog");
        f.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        DefaultTableModel model = new DefaultTableModel();
        JTable table = new JTable(model);
        JProgressBar jpb = new JProgressBar();
        f.add(jpb, BorderLayout.NORTH);
        f.add(new JScrollPane(table));
        f.pack();
        f.setLocationRelativeTo(null);
        f.setVisible(true);
        LogWorker lw = new LogWorker(new File(NAME), model);
        lw.addPropertyChangeListener((PropertyChangeEvent e) -> {
            SwingWorker.StateValue s = (SwingWorker.StateValue) e.getNewValue();
            jpb.setIndeterminate(s.equals(SwingWorker.StateValue.STARTED));
        });
        lw.execute();
    }

    public static void main(String[] args) {
        EventQueue.invokeLater(() -> {
            new DisplayLog().display();
        });
    }
}