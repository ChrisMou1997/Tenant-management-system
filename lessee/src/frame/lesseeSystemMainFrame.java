package frame;

import bean.user;
import dao.ManageHelper;
import util.WindowUtil;

import javax.imageio.ImageIO;
import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowEvent;
import java.awt.event.WindowListener;
import java.io.IOException;

//������
public class lesseeSystemMainFrame extends JFrame {
	private JMenuBar menuBar;	//Ӧ�ò˵�����
	private JMenu lessee_Management;	//"�⻧����"�˵���

/*	private JMenu score_Management;	//"�ɼ�����"�˵���*/

	private JMenu personal_Management;	//"���˹���"�˵���
	private JMenuItem add_lessee;	//"����⻧"�˵��
	private JMenuItem query_lessee;	//"��ѯ�⻧��Ϣ"�˵��
	private JMenuItem modify_lessee;	//"�޸��⻧��Ϣ"�˵��
	private JMenuItem delete_lessee;	//"ɾ���⻧"�˵��

	/*private JMenuItem add_Score;	//"����⻧�ɼ�"�˵��
	private JMenuItem modify_Score;	//"�޸��⻧�ɼ�"�˵��
	private JMenuItem query_Score;	//"�ɼ���ѯ"�˵��
	private JMenuItem score_Statistics;	//"�ɼ�ͳ��"�˵��*/

	private JMenuItem change_Password;	//"�޸�����"�˵��
	private JMenuItem logout;	//"�˳���¼"�˵��
	private JFrame jf;	//��ǰ���ڡ�
	private user user;//��ǰ�û���
	public lesseeSystemMainFrame(user user){
		super("�⻧����ϵͳ,��ӭ��"+user.getUsername());
		this.user = user;
		this.jf = this;
		menuBar = new JMenuBar();	//�����˵�����
		this.setJMenuBar(menuBar);	//��Ӳ˵�����
		
		lessee_Management = new JMenu("�⻧����");	//����"�⻧����"�˵���
		menuBar.add(lessee_Management);	//���"�⻧����"�˵���
		
		add_lessee = new JMenuItem("����⻧");	//����"����⻧"�˵��
		//ע��"����⻧"�˵����¼�����
		add_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub
				AddlesseeFrame addlesseeFrame = new AddlesseeFrame(jf,"����⻧",true);
			}
		});
		lessee_Management.add(add_lessee);	//���"����⻧"�˵��
		
		query_lessee = new JMenuItem("��ѯ�⻧��Ϣ");	//����"��ѯ�⻧"�˵��
		//ע��"��ѯ�⻧"�˵����¼�������
		query_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				QuerylesseeFrame querylesseeFrame = new QuerylesseeFrame(jf, "��ѯ�⻧��Ϣ", true);
				
			}
		});
		lessee_Management.add(query_lessee);	//���"��ѯ�⻧��Ϣ"�˵��
		
		modify_lessee = new JMenuItem("�޸��⻧��Ϣ");	//����"�޸��⻧��Ϣ"�˵��
		//ע��"�޸��⻧��Ϣ"�˵����¼�����
		modify_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				ModifylesseeFrame modifylesseeFrame = new ModifylesseeFrame(jf, "�޸��⻧��Ϣ", true);
				
			}
		});
		lessee_Management.add(modify_lessee);	//���"�޸��⻧"�˵��
		
		delete_lessee = new JMenuItem("ɾ���⻧");	//����"ɾ���⻧"�˵��
		//ע��"ɾ���⻧"��ť�¼�����
		delete_lessee.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				DeletelesseeFrame deletelesseeFrame = new DeletelesseeFrame(jf, "ɾ���⻧", true);
				
			}
		});
		lessee_Management.add(delete_lessee);	//���"ɾ���⻧"�˵���.
		
		personal_Management = new JMenu("���˹���");	//����"���˹���"�˵���
		menuBar.add(personal_Management);	//���"���˹���"�˵���
		
		change_Password = new JMenuItem("�޸�����");	//����"�޸�����"�˵��
		//ע��"�޸�����"�˵����¼�����
		change_Password.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) {
				UpdatePasswordFrame frame = new UpdatePasswordFrame(jf, "�޸�����", true,user);
			}
		});
		personal_Management.add(change_Password);	//���"�޸�����"�˵��
		
		logout = new JMenuItem("�˳���¼");	//����"�˳���¼"�˵��
		//ע��"�˳���¼"�˵���ʱ�����
		logout.addActionListener(new ActionListener() {
			
			@Override
			public void actionPerformed(ActionEvent e) { 
				jf.dispose();	//�رյ�ǰ����
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				lesseeSystemLoginFrame frame = new lesseeSystemLoginFrame();	//�򿪵�½����
				
			}
		});
		personal_Management.add(logout);	//���"�˳���¼"�˵��
		
		this.setSize(578, 400);
		this.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		this.setResizable(false);
		WindowUtil.setFrameCenter(this);//���ô�����С�
		ImagePanel imagePanel = new ImagePanel();
		setContentPane(imagePanel);
		
		try {
			Image img = ImageIO.read(this.getClass().getResource("/2.png"));
			this.setIconImage(img);
			
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		
	     
		this.setVisible(true);//���ô���ɼ���
		this.addWindowListener(new WindowListener() {
			
			@Override
			public void windowOpened(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowIconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeiconified(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowDeactivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowClosing(WindowEvent arg0) {
				// TODO Auto-generated method stub
				//�޸ĵ�½״̬
				ManageHelper helper = new ManageHelper();
				user.setIsLogin(0);//���õ�½״̬Ϊδ��¼��
				helper.Update_IsLogin(user);
				
			}
			
			@Override
			public void windowClosed(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
			
			@Override
			public void windowActivated(WindowEvent arg0) {
				// TODO Auto-generated method stub
				
			}
		});
	}
	
	
	
}
