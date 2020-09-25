package deal;

import Interface.AllRiversStatus;
import dao.RiverDao;
import exception.riverException;
import model.River;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

/**
 * Created with IntelliJ IDEA.
 * Description: If you don't work hard, you will a loser.
 * User: Listen-Y.
 * Date: 2020-09-06
 * Time: 15:28
 */
public class CheckBoxShows implements ActionListener {

    private AllRiversStatus event;


    public CheckBoxShows(AllRiversStatus event) {
        this.event = event;
    }

    @Override
    public void actionPerformed(ActionEvent e) {

        JCheckBox check = (JCheckBox) e.getSource();

        try {

            switch (check.getText()) {
                case "分布情况":
                    event.lengthCheck.setSelected(false);
                    event.statusCheck.setSelected(false);
                    distribution();
                    break;
                case "治理情况":
                    event.lengthCheck.setSelected(false);
                    event.locationCheck.setSelected(false);
                    governance();
                    break;
                case "长度占比":
                    event.locationCheck.setSelected(false);
                    event.statusCheck.setSelected(false);
                    proportionOfLength();
                    break;
            }

        } catch (riverException ex) {
            JOptionPane.showMessageDialog(event, "数据库异常");
        }

    }

    //分布情况
    private void distribution() throws riverException {

        clear();

        Map<String, Integer> map = findAnswerDistribution();
        int index = 0;
        event.answerPanel.setSize(210, 300);
        event.answerPanel.setLocation(180, 80);
        for (Map.Entry<String, Integer> entry : map.entrySet()
             ) {
            event.labels[index].setText(entry.getKey() + ":");
            event.answers[index].setText(entry.getValue() + " (条)");
            index++;
        }
    }

    private void clear() {
        for (int i = 0; i < 6; i++) {
            event.labels[i].setText("");
            event.answers[i].setText("");
        }
    }

    private Map<String, Integer> findAnswerDistribution() throws riverException {
        Map<String, Integer> map = new HashMap<>();
        RiverDao dao = new RiverDao();
        List<River> rivers = dao.SelectAll();
        for (River river : rivers
             ) {
            map.put(river.getRiver_class(),
                    map.getOrDefault(river.getRiver_class(), 0) + 1);
        }
        return map;
    }

    //治理情况
    private void governance() throws riverException {

        clear();

        Map<String, Integer> map = findAnswerGovernance();
        int index = 0;
        event.answerPanel.setSize(110, 300);
        event.answerPanel.setLocation(230, 80);
        for (Map.Entry<String, Integer> entry : map.entrySet()
             ) {
            event.labels[index].setText(entry.getKey() + ":");
            event.answers[index].setText(entry.getValue() + " (条)");
            index++;
        }

    }

    private Map<String, Integer> findAnswerGovernance() throws riverException {

        Map<String, Integer> map = new HashMap<>();
        RiverDao dao = new RiverDao();
        List<River> rivers = dao.SelectAll();
        for (River river : rivers
        ) {
            map.put(river.getRiver_status(),
                    map.getOrDefault(river.getRiver_status(), 0) + 1);
        }
        return map;
    }

    //长度占比
    private void proportionOfLength() throws riverException {

        clear();

        int[] counts = findAnswerProportionOfLength();
        String[] lengthsS = new String[] {"小于2000 (Km):", "小于10000 (Km):", "大于10000 (Km):"};
        event.answerPanel.setSize(250, 300);
        event.answerPanel.setLocation(170, 80);
        for (int i = 0; i < counts.length; i++) {
            event.labels[i].setText(lengthsS[i]);
            event.answers[i].setText(counts[i] + " (条)");
        }
    }

    private int[] findAnswerProportionOfLength() throws riverException {

        int[] counts = new int[] {0, 0, 0};
        RiverDao dao = new RiverDao();
        List<River> rivers = dao.SelectAll();

        for (River river : rivers
             ) {
            if (Integer.parseInt(river.getRiver_length()) < 2000) {
                counts[0]++;
            } else if (Integer.parseInt(river.getRiver_length()) < 10000) {
                counts[1]++;
            } else {
                counts[2]++;
            }
        }
        return counts;
    }
}
