package dao;

import bean.lessee;
import bean.user;

import java.util.Vector;


//���ݿ�ҵ������
public class ManageHelper {
	private JdbcHelper helper;	//�����ݿ�ͨ�ŵĶ���
	
	
	
	/**
	 * ��½ҵ����
	 * @param user	�û�����
	 * @return �����Ƿ�ɹ���½
	 */
	public boolean Login(user user){
		boolean b = true;
		helper = new JdbcHelper();	//���������ݿ�ͨ�ŵĶ���
		user newUser = helper.getUser(user);	//����û�����
		if(!user.getPassword().equals(newUser.getPassword())){	//�ȶ����������ݿ��еĶ�Ӧ�����Ƿ�һ��
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ע��ҵ����
	 * @param user �û�����
	 * @return	�����Ƿ�ע��ɹ�
	 */
	public boolean Register(user user){
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		boolean b = helper.register(user);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ����Ƿ��ظ���½�ķ���
	 * @param user �û�����
	 * @return �Ƿ��ظ���½,��½���ķ���true,���򷵻�false
	 */
	public boolean Check_IsLogin(user user){
		boolean b = true;
		int isLogin;
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		user newUser = helper.getUser(user);
		if(newUser.getIsLogin()==0){
			b = false;
		}
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * ���سɹ��޸ĵ�½���
	 * @param user �û�����
	 */
	public boolean  Update_IsLogin(user user){
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		boolean b = helper.update_IsLogin(user);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	
	/**
	 * �޸�����ҵ����
	 * @param user	�û�����
	 * @param new_Password	������
	 * @return �����Ƿ��޸ĳɹ�
	 */
	public boolean update_Password(user user,String new_Password){
		boolean b;
		helper = new JdbcHelper();//���������ݿ�ͨ�ŵĶ���
		b = helper.update_Password(user, new_Password);
		helper.close();//�ر���Դ
		return b;
	}
	
	/**
	 * ����⻧ҵ��
	 * @param _lessee �⻧����
	 * @return �����Ƿ���ӳɹ�
	 */
	public boolean addlessee(lessee _lessee){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.addLessee(_lessee);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * �޸��⻧ҵ��
	 * @param newLessee	���⻧����
	 * @param oldLesseeID	���⻧��Ϣ
	 * @return	�����Ƿ���ӳɹ�
	 */
	public boolean updateSlessee(lessee newLessee,String oldLesseeID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.updateLessee(newLessee, oldLesseeID);
		helper.close();//�ر���Դ
		return b;
	}
	
	
	/**
	 * ɾ���⻧ҵ��
	 * @param lesseeID	�⻧ѧ��
	 * @return	�����Ƿ�ɾ���ɹ�
	 */
	public boolean deleteLessee(String lesseeID){
		boolean b = true;
		helper = new JdbcHelper();
		b = helper.deleteLessee(lesseeID);
		helper.close();
		return b;
	}
	
	
	/**
	 * ����sql��䷵���ض����⻧���󼯺�
	 * @param sql	sql���
	 * @return	�����⻧����
	 */
	public Vector<lessee> getlessee(String sql){
		Vector<lessee> lessees;
		helper = new JdbcHelper();
		lessees = helper.getlessee(sql);
		helper.close();
		return lessees;
	}
}
