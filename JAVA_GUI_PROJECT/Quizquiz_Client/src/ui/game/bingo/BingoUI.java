package ui.game.bingo;

import java.awt.GridLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JPanel;

import data.gameRoom.GameRoom;
import data.network.ClientNetworkInfo;
import game.bingo.BingoGameNetwork;

public class BingoUI extends JPanel {
   Map response;
   public JLabel[][] lbBingo;
   public JButton[][] tbts;
   public List<JButton> tbtList;
   Set<String> bingo = new HashSet<>();
   GameRoom gameRoom;
   BingoGameNetwork bingoGameNetwork;
   public String[][] lbbs = new String[5][5];

   public BingoUI(GameRoom gameRoom) {
      setLayout(new GridLayout(1, 0, 0, 0));
      this.gameRoom = gameRoom;
      init();

   }

   public void addActionListener(ClientNetworkInfo clientNetworkInfo, BingoGameNetwork bingoGameNetwork) { // �׼� ó��
      this.bingoGameNetwork = bingoGameNetwork;
	  this.bingoGameNetwork.clientNetwork = clientNetworkInfo;
      for (JButton bt : tbtList) {
         bt.addActionListener(new ActionListener() {
            public void actionPerformed(ActionEvent e) {
//               bt.setEnabled(false);
               String[] num = (String[]) (bt.getActionCommand().split(","));
               int[] number = new int[2];
               number[0] = (int) (Integer.parseInt(num[0]));
               number[1] = (int) (Integer.parseInt(num[1]));
               System.out.println(lbbs[number[0]][number[1]]);
               String nums = lbbs[number[0]][number[1]];
//               System.out.println(nums);
               bingoGameNetwork.bingoGameAction(nums); // ���� ��ư �ؽ�Ʈ ������ ������ �����ϴ� �޼ҵ� ȣ��
            }
         });
      }

   }

   public void init() {
      setSize(300, 300);
      JPanel p = new JPanel();
      p.setLayout(new GridLayout(5, 5, 1, 1));
      tbts = new JButton[5][5];

      tbtList = new ArrayList<>();
//      String start = Integer.toString((int) (Math.random() * 25) + 1); // ��ư�� ������ �ʱⰪ ����
//      bingo.add(start);
//      System.out.println(bingo);
      System.out.println("�ʱⰪ �߰� �Ϸ�");
      for (int row = 0; row < 5; row++) { // ���� ��ư ���� �ݺ���
         for (int col = 0; col < 5; col++) {
            JLabel lbb = new JLabel();
            JButton b = new JButton();
            b.setActionCommand(row + "," + col);
            lbbs[row][col] = Integer.toString((int) (Math.random() * 25) + 1);
//            System.out.println(lbbs[row][col]);
            while (bingo.contains(lbbs[row][col])) { // �ߺ�ó��
//               System.out.println(bingo + "." + (row + col));
               String lbNew = Integer.toString((int) (Math.random() * 25) + 1);
               lbbs[row][col] = lbNew;
//               System.out.println("change " + lbbs[row][col]);
//               if (bingo.size() == 25) {
//                  break;
//               }
            }
            bingo.add(lbbs[row][col]);
            lbb.setText(lbbs[row][col]);
            b.add(lbb);
            p.add(b);
            tbts[row][col] = b;
            tbtList.add(b);
         }
      }
      this.add(p);
   }
}
