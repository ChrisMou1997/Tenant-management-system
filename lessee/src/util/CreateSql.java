package util;
//����sql���Ĺ�����
public class CreateSql {

	//���ݲ�ѯ���ݡ�ѡ����⻧���ﷵ���ض���sql���
	public static String getlessee_Sql(String str,String option){
		String sql = null;
		if("ȫ��".equals(option)){
			sql = "select * from tb_lessee" ;
		}else if("���".equals(option)){
			sql = "select * from tb_lessee where lesseeID like '%"+str+"%'";
		}else if("����".equals(option)){
			sql = "select * from tb_lessee where lesseeNAME like '%"+str+"%'";
		}else if("�Ա�".equals(option)){
			sql = "select * from tb_lessee where lesseeSEX like '%"+str+"%'";
		}else if("����".equals(option)){
			sql = "select * from tb_lessee where lesseeAGE like '%"+str+"%'";
		}else if("ʱ��".equals(option)){
			sql = "select * from tb_lessee where lesseetime  like '%"+str+"%'";
		}else if("���".equals(option)){
			sql = "select * from tb_lessee where lesseeMoney like '%"+str+"%'";
		}
		return sql;
	}
	
	//��������ѯ��sql��䴴��
	public static String getConditions_Sql(String id,String name,String sex,String age,String rent,String time){
		StringBuilder sql = new StringBuilder("select * from tb_lessee where 1=1");
		if(!id.equals("")){
			sql.append(" and lesseeID like '%" + id + "%'  ");
		}
		if(!name.equals("")){
			sql.append(" and lesseeNAME like '%" + name + "%'  ");
		}
		if(!sex.equals("")){
			sql.append(" and lesseeSEX like '%" + sex + "%'  ");
		}
		if(!age.equals("")){
			sql.append(" and lesseeAGE like '%" + age + "%'  ");
		}
		if(!rent.equals("")){
			sql.append(" and lesseeMoney like '%" + rent + "%'  ");
		}
		if(!time.equals("")){
			sql.append(" and lesseetime like '%" + time + "%'  ");
		}
		return sql.toString();
	}
	
	//���ݲ�ѯ���ݡ�ѡ����⻧���ﷵ���ض���sql���
		public static String getlessee_Sql(String age,String time,String str,String option){
			String sql = null;
			if("ȫ��".equals(option)){
				sql = "select * from tb_lessee where lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("���".equals(option)){
				sql = "select * from tb_lessee where lesseeID like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("����".equals(option)){
				sql = "select * from tb_lessee where lesseeNAME like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("�Ա�".equals(option)){
				sql = "select * from tb_lessee where lesseeSEX like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}else if("����".equals(option)){
				sql = "select * from tb_lessee where lesseeAGE like '%"+str+"%' and lesseeAGE='"+age+"' and lesseetime='"+time+"'" ;
			}
			return sql;
		}
	
	
	
	
}
