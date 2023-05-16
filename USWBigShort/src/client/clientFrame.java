package client;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

public class clientFrame extends JFrame implements ActionListener {
    Container c;
    private JLabel priceLabel;
    private JLabel nameLabel;
    private JLabel changeRateLabel;
    private JButton sellBtn;
    private JButton buyBtn;
    clientFrame(){
        setTitle("테스트 클라이언트 프레임");
        setSize(300, 400);
        c = new Container();
        c.setLayout(new FlowLayout());
        //패턴 써먹어보고 싶은데 어떻게 적용시켜야할지 잘 모르겠는 부분
        //뭔가 늘어날때마다 코드가 계속 배로 늘어나야하고 일일이 수정해야하는게 문제일거같음
        priceLabel = new JLabel("테스트 코인 가격");
        nameLabel = new JLabel("테스트 코인 이름");
        changeRateLabel = new JLabel("테스트 코인 변동률");
        sellBtn = new JButton("판매버튼");
        sellBtn.addActionListener(this);
        buyBtn = new JButton("구매버튼");
        buyBtn.addActionListener(this);
        c.add(nameLabel);
        c.add(priceLabel);
        c.add(changeRateLabel);
        c.add(sellBtn);
        c.add(buyBtn);
        setVisible(true);
        add(c);
    }

    public JLabel getNameLabel() {
        return nameLabel;
    }

    public JLabel getPriceLabel() {
        return priceLabel;
    }

    public JLabel getChangeRateLabel() {
        return changeRateLabel;
    }

    public JButton getBuyBtn() {
        return buyBtn;
    }
    public JButton getSellBtn() {
        return sellBtn;
    }

    public void setLabelText(JLabel jLabel, String text){
        jLabel.setText(text);
    }
    public void LabelUpdate(Coin coin) {
        /*얘를 사용해서 하는게 더 낫나 싶긴한데 일단은 메모만..
         @Override
        public void update(Graphics g) {
            super.update(g);
        }
         */
        setLabelText(nameLabel, coin.getName());
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        if(e.getSource() == buyBtn){

        }else if (e.getSource() == sellBtn){

        }
    }
}
