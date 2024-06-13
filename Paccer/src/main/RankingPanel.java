package main;

import javax.swing.JPanel;
import javax.swing.JTable;
import javax.swing.JScrollPane;
import javax.swing.table.DefaultTableModel;
import DataBase.GameResult;
import DataBase.RankingEntry;

import java.util.List;
import java.util.Map;

public class RankingPanel extends JPanel {
    private JTable table;
    private DefaultTableModel tableModel;

    public RankingPanel() {
        setLayout(null);

        String[] columnNames = {"Player ", "Wins"};
        tableModel = new DefaultTableModel(columnNames, 0) {
            @Override
            public boolean isCellEditable(int row, int column) {
                return false;
            }
        };
        table = new JTable(tableModel);
        JScrollPane scrollPane = new JScrollPane(table);
        scrollPane.setBounds(50, 50, 300, 200);
        add(scrollPane);

        loadRankingData();
    }

    private void loadRankingData() {
        List<RankingEntry> rankingData = GameResult.getRanking();
        for (RankingEntry entry : rankingData) {
            String player = entry.getWinner();
            int wins = entry.getWins();
            tableModel.addRow(new Object[]{player, wins});
        }
    }
}