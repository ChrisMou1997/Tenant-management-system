package frame;

import dao.ManageHelper;
import model.lesseemodel;
import util.CreateSql;
import util.WindowUtil;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.Vector;

//ɾ���⻧����
public class DeletelesseeFrame extends JDialog{
	private JPanel jp1,jp2,jp3;	//��塣
	private JLabel query_Label;	//��ǩ��
	private JButton query_Button;	//"��ѯ"��ť��
	private JComboBox query_List;	//"��ѯ"ѡ�
	private JButton preciseQuery_Button;	//"��ȷ��ѯ"��ť��
	private JButton delete_Button;	//"ɾ��"��ť��
	private JTextField query_Text;	//"��ѯ"�ı���
	private JTable jt;	//���
	private JScrollPane jsp;	//��������
	private JDialog jd;	//��ǰ���ڡ�
	private lesseemodel lesseemodel;	//�⻧����ģ��
	private static Vector<String> query_Option;
	
	static {
		query_Option = new Vector<String>();
		query_Option.add("ȫ��");
		query_Option.add("���");
		query_Option.add("����");
		query_Option.add("�Ա�");
		query_Option.add("����");
		query_Option.add("ʱ��");
		query_Option.add("���");
	}
	/**
	 * 
	 * @param owner ���ĸ�����
	 * @param title ������
	 * @param modal ָ����ģʽ���ڣ����з�ģʽ����
	 */
	public DeletelesseeFrame(JFrame owner, String title, boolean modal){
		super(owner, title, modal);
		this.jd = this;
		Container c = this.getContentPane();
		jp1 = new JPanel();
		query_Label = new JLabel("�������ѯ��Ϣ:");
		jp1.add(query_Label);
		
		query_Text = new JTextField(10);
		jp1.add(query_Text);
		
		query_List = new JComboBox<String>(query_Option);
		jp1.add(query_List);
		
		query_Button = new JButton("��ѯ");
		//ע��"��ѯ"��ť�¼�����
				query_Button.addActionListener(new ActionListener() {
					
					@Override
					public void actionPerformed(ActionEvent arg0) {
						String str = query_Text.getText().trim();	//��ѯ����
						String option = query_List.getSelectedItem().toString();	//��ѯѡ��
						String sql = CreateSql.getlessee_Sql(str, option);	//���sql���
						lesseemodel = new lesseemodel(sql,jd);//�����µ�����ģ���࣬������
						jt.setModel(lesseemodel);//����Jtable
					}
				});		
		jp1.add(query_Button);
		
		preciseQuery_Button = new JButton("��������ѯ");
		jp1.add(preciseQuery_Button);
		c.add(jp1,BorderLayout.NORTH);	//������
	
		jp2 = new JPanel();
		jt = new JTable();
		String sql = CreateSql.getlessee_Sql(null, "ȫ��");//��ѯȫ������
		lesseemodel = new lesseemodel(sql,jd);//�����µ�����ģ���࣬������
		jt.setModel(lesseemodel);
		
		jsp = new JScrollPane(jt);
		jp2.add(jsp);
		c.add(jp2,BorderLayout.CENTER);	//������
		
		jp3 = new JPanel();
		delete_Button = new JButton("ɾ��");
		//ע��"ɾ��"��ť�¼�����
		delete_Button.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				int rowNum = jt.getSelectedRow();
				if(rowNum==-1){
					JOptionPane.showMessageDialog(jd, "��ѡ��һ�У�", "", JOptionPane.WARNING_MESSAGE);
					return ;
				}
				String lesseeID = jt.getValueAt(rowNum,0).toString();
				ManageHelper helper = new ManageHelper();
				if(helper.deleteLessee(lesseeID)){
					JOptionPane.showMessageDialog(jd, "ɾ���ɹ���");
					//����
					//�����µ�����ģ���࣬������
					String sql = CreateSql.getlessee_Sql(null, "ȫ��");//��ѯȫ������
					lesseemodel = new lesseemodel(sql,jd);//�����µ�����ģ���࣬������
					jt.setModel(lesseemodel);
					return ;
				}else{
					JOptionPane.showMessageDialog(jd, "ɾ��ʧ�ܣ�","",JOptionPane.WARNING_MESSAGE);
					return ;
				}
			}
		});
		jp3.add(delete_Button);
		c.add(jp3,BorderLayout.SOUTH);
	
		this.setSize(600,540);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);//���ô�����С�
		this.setVisible(true);
	}
}
