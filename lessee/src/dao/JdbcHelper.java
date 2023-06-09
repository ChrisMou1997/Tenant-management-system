package dao;

import bean.lessee;
import bean.user;


import java.util.Vector;

import java.sql.*;


public class JdbcHelper implements JdbcConfig{
	//�����������ݿ�����Ҫ�Ķ���
	private PreparedStatement ps = null;
	private ResultSet rs = null;
	private Connection ct = null;
	

	//������ݿ������
	private  void init(){
		try {
			Class.forName(DRIVER);
			ct = DriverManager.getConnection(URL, USERNAME, PASSWORD);// ������ݿ�����
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}

	}
	
	//�޲ι��캯��
	public JdbcHelper(){
		this.init();
	}
	

	/**
	 * ��ȡ�û�����
	 * ���ݴ�����û�������ȡ��Ӧ���û����������û�����
	 * @return �û�����
	 */
	public user getUser(user user){
		user newUser = new user();
		try {
			ps = ct.prepareStatement("select * from tb_user where User_name=?");
			ps.setString(1, user.getUsername());
			rs = ps.executeQuery();
			if(rs.next()){
				newUser.setUsername(rs.getString(1));	//�����û���
				newUser.setPassword(rs.getString(2));	//��������
				newUser.setIsLogin(rs.getInt(3));	//�����Ƿ��½
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
		return newUser;
	}
	
	/**
	 * ע�ᴦ��
	 * @param user	�û�����
	 * @return	�����Ƿ�ע��ɹ�
	 */
	public boolean register(user user){
		boolean b = true;
		try {
			ps = ct.prepareStatement("insert into tb_user(User_name,Password_) values(?,?)");
			ps.setString(1, user.getUsername());
			ps.setString(2, user.getPassword());
			if(ps.executeUpdate()!=1){	//ִ��sql���
				b = false;
			}
		} catch (SQLException e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	/**
	 * �޸��û�"�Ƿ�"��½״̬
	 * @param user
	 * @return
	 */
	public boolean update_IsLogin(user user){
		boolean b = true;
		try {
			ps = ct.prepareStatement("update tb_User set IsLogin=? where User_name=?");
			ps.setInt(1, user.getIsLogin());
			ps.setString(2, user.getUsername());
			if(ps.executeUpdate()!=1){
				b = false;
			}
		} catch (SQLException e) {
			b = false;
			e.printStackTrace();
		}
		return b;
	}
	
	
	
	
	
		/**
		 * �޸�����
		 * @param user  �û�����
		 * @param new_Password ������
		 * @return	�����Ƿ��޸ĳɹ�
		 */
		public boolean update_Password(user user,String new_Password){
			boolean b = true;
			try {
				ps = ct.prepareStatement("update tb_User set Password_=? where User_name=?");
				ps.setString(1, new_Password);
				ps.setString(2, user.getUsername());
				if(ps.executeUpdate()!=1){	//ִ��sql���
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}

		/**
		 * ����⻧
		 * @param _lessee	�⻧����
		 * @return	�����Ƿ���ӳɹ�
		 */
		public boolean addLessee(lessee _lessee){
			boolean b = true;
			try {
				ps = ct.prepareStatement("insert into tb_lessee(lesseeID,lesseeSEX,lesseeNAME,lesseeAGE,lesseeMoney,lesseeTime) values(?,?,?,?,?,?)");
				ps.setString(1, _lessee.getLesseeID() );
				ps.setString(2, _lessee.getLesseeSEX());
				ps.setString(3, _lessee.getLesseeNAME());
				ps.setString(4, _lessee.getLesseeAGE());
				ps.setString(5, _lessee.getlesseeMoney());
				ps.setString(6, _lessee.getlesseetime());
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		
		/**
		 * �޸��⻧��Ϣ
		 * @param newLessee	���⻧����
		 * @param oldLesseeID	���⻧��Ϣ
		 * @return	�Ƿ��޸ĳɹ�
		 */
		public boolean updateLessee(lessee newLessee,String oldLesseeID){
			boolean b = true;
			try {
				//update
				ps = ct.prepareStatement("update tb_lessee set lesseeID=?, lesseeSEX=?, lesseeNAME=? ,lesseeAGE=? ,lesseeMoney=?,lesseeTime=? where lesseeID=?");
				ps.setString(1, newLessee.getLesseeID() );
				ps.setString(2, newLessee.getLesseeSEX());
				ps.setString(3, newLessee.getLesseeNAME());
				ps.setString(4, newLessee.getLesseeAGE());
				ps.setString(5, newLessee.getlesseeMoney());
				ps.setString(6, newLessee.getlesseetime());
				ps.setString(7, oldLesseeID);
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		
		/**
		 * �����⻧ѧ�Ŵ����ݿ��Ƴ����⻧
		 * @param _lesseeID	�⻧ѧ��
		 * @return	�����Ƿ�ɾ���ɹ�
		 */
		public boolean deleteLessee(String _lesseeID){
			boolean b = true;
			try {
				ps = ct.prepareStatement("delete from tb_lessee where lesseeID=?");
				ps.setString(1, _lesseeID);
				if(ps.executeUpdate()!=1){
					b = false;
				}
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				b = false;
				e.printStackTrace();
			}
			return b;
		}
		

		/**
		 * ����sql��䷵���ض����⻧����
		 * @param sql	sql���
		 * @return	����Vector<lessee>����
		 */
		public Vector<lessee> getlessee(String sql){
			Vector<lessee> lessees = new Vector<lessee>();
			try {
				ps = ct.prepareStatement(sql);
				rs = ps.executeQuery();
				while(rs.next()){
					lessee _lessee = new lessee();
					_lessee.setLesseeID(rs.getString(1));
					_lessee.setLesseeSEX(rs.getString(2));
					_lessee.setLesseeNAME(rs.getString(3));
					_lessee.setLesseeAGE(rs.getString(4));
					_lessee.setlesseeMoney(rs.getString(5));
					_lessee.setlesseetime(rs.getString(6));
					lessees.add(_lessee);
				}
			}catch(SQLException e){
				e.printStackTrace();
			}
			return lessees;
		}

		//�ر����ݿ���Դ
		public void close()	{
			try {
				if(rs!=null) rs.close();
				if(ps!=null) ps.close();
				if(ct!=null) ct.close();
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	
	
}
