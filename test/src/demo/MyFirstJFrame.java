package demo;

import java.awt.Component;
  import java.awt.event.ActionEvent;
  import java.awt.event.ActionListener;
  
  import javax.swing.*;
  import javax.swing.table.*;
  
  
  public class MyFirstJFrame extends JFrame {
      
      // ��Ϊ���Ե�main����
      public static void main(String[] args) {
          new MyFirstJFrame().setVisible(true);
      }
      
      /**
       * ���췽��
       */
      public MyFirstJFrame() {
          InitialComponent();
      }
      
      /**
       * ��ʼ������ķ���
       */
      private void InitialComponent(){
          // ���ô������
  
          // ���ò���ģʽ
           setLayout(null);
          // ���ô����С
          setSize(480, 360);
          // ���ô�����У��ǳ��淽����
           setLocationRelativeTo(null);
          // �رմ����˳�����
          setDefaultCloseOperation(DISPOSE_ON_CLOSE);
          
          // ��ʼ�����
          panel = new JPanel();
          panel.setSize(this.getWidth(), this.getHeight());
          panel.setLocation(0,0);
          panel.setLayout(null);
          
          // ��ʼ�����
          table = new JTable(new DefaultTableModel(new Object[][]{{"��һ��"},{"�ڶ���"},{"������"},{"������"}}, new String[]{"������1","������2"}){
              /* (non-Javadoc)
               * ��д�������жϱ�Ԫ���Ƿ�ɱ༭
               * ����ͨ��row��column�����ж�ĳһ����Ԫ���Ƿ�ɱ༭
               * �˴���Ϊ�����ɱ༭
               * @see javax.swing.table.DefaultTableModel#isCellEditable(int, int)
               */
              @Override
              public boolean isCellEditable(int row, int column) {
                  return false;
              }
          });
          
          // ��ʼ��������Ӹ�ѡ��ע�⣺��ʾ����Ϊ�򵥣�ȱʡ�ܶ��жϣ�Ҳû�ж�̬����֧�֣�
          // ͨ����������Ⱦ
          
          // ����һ��ֱ�ӷ�ʽ ʹ��TableColumn��setCellRenderer�������Ƽ���
          // �˷�����������ĳһ�е���Ⱦ����ʹ��ĳһ�����--���ؼ�����ʾ��Ԫ�����ݣ�
          table.getColumnModel().getColumn(1).setCellRenderer(new TableCellRenderer(){
  
               /*(non-Javadoc)
               * �˷��������򷽷������߷���ĳһ��Ԫ�����Ⱦ��������ʾ���ݵ��齨--��ؼ���
               * ����ΪJCheckBox JComboBox JTextArea ��
               * @see javax.swing.table.TableCellRenderer#getTableCellRendererComponent(javax.swing.JTable, java.lang.Object, boolean, boolean, int, int)
               */
              @Override
              public Component getTableCellRendererComponent(JTable table,
                      Object value, boolean isSelected, boolean hasFocus,
                      int row, int column) {
                  // �������ڷ��ص���Ⱦ���
                  JCheckBox ck = new JCheckBox();
                  // ʹ���н�����ж�Ӧ�ĸ�ѡ��ѡ��
                  ck.setSelected(isSelected);
                  // ���õ�ѡbox.setSelected(hasFocus);
                  // ʹ��ѡ���ڵ�Ԫ���ھ�����ʾ
                  ck.setHorizontalAlignment((int) 0.5f);
                  return ck;
              }});
          
          // ���������������б༭����Ȼ�����õ�Ԫ����Ⱦ
          // �����б༭��
          // ���Ը�ѡ��Ϊ���������б༭��ʱ�����뱣֤�����ܹ����༭�������޷�����״̬
          // ���˲������ʡ�ԣ�ʡ��ʱ��Ҫ���ǽ�����Ϊ���ɱ༭��
          // table.getColumnModel().getColumn(1).setCellEditor(new DefaultCellEditor(new JCheckBox()));
          
          // ���õ�Ԫ����Ⱦ�����������ñ�񼶱����Ⱦ��
          /*table.setDefaultRenderer(Object.class, new TableCellRenderer(){
  
              @Override
              public Component getTableCellRendererComponent(JTable table,
                      Object value, boolean isSelected, boolean hasFocus,
                      int row, int column) {
                  // �ж��Ƿ�Ϊ��Ҫ��Ⱦ����
                  if(column == 1){
                      // �ͷ���һ����һ��
                      JCheckBox box = new JCheckBox();
                      box.setSelected(isSelected);
                      // ���õ�ѡbox.setSelected(hasFocus);
                      box.setHorizontalAlignment((int) CENTER_ALIGNMENT);    // 0.5f
                      return box;
                      }
                  // ���������Ҫ��Ⱦ���У���װ�ı�����ʾ����
                  return new JTextArea(value.toString());
              }});*/
          
          // �ڶ�ѡ����Ҫ��סCtrl��������갴ס�Ϲ���������Ҫѡ�е��У�Ӧ�ø��û�˵��
          // ��һ�ַ����Ǳ��Ƽ��ģ���Ϊ������ѡ�еĸ�����ʾ�������ܸ����Ѻ�
          table.setSize(panel.getWidth(),panel.getHeight() - 90);
          table.setLocation(0, 0);
          
          
          btn = new JButton("Test");
          btn.setSize(80,40);
          btn.setLocation((panel.getWidth()) / 2 - 40, panel.getHeight() - 80);
          
          // ��ť���ʱ��ʾ��ǰѡ����
          btn.addActionListener(new ActionListener(){
  
              @Override
              public void actionPerformed(ActionEvent e) {
                  for(int rowindex : table.getSelectedRows()){
                      JOptionPane.showMessageDialog(null, rowindex + " " + table.getValueAt(rowindex, 0));
                  }
              }});
          
          panel.add(table);
          panel.add(btn);
          this.add(panel);    
          
      }
      
      // ����һЩ��Ҫ�����
      private JPanel panel;
      private JTable table;
      private JButton btn;
  }