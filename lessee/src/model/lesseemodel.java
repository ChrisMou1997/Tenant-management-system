package model;

import bean.lessee;
import dao.ManageHelper;

import java.util.Vector;

import javax.swing.JDialog;
import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;
//rowData�������������
//columnNames�������
public class lesseemodel extends AbstractTableModel {
    private ManageHelper helper;
    private Vector<lessee> lessees;
    private  Vector<String> columnNames = null;	//����
    private Vector<Vector<String>> rowData = null;	//������

    public lesseemodel(String sql,JDialog jd) {
        helper = new ManageHelper();
        lessees = helper.getlessee(sql);

        columnNames = new Vector<String>();
        rowData = new Vector<Vector<String>>();
        columnNames.add("���");
        columnNames.add("�Ա�");
        columnNames.add("����");
        columnNames.add("����");
        columnNames.add("���");
        columnNames.add("�ⷿʱ��");
        for(lessee _lessee : lessees){
            Vector<String> hang = new Vector<String>();
            hang.add(_lessee.getLesseeID());
            hang.add(_lessee.getLesseeSEX());
            hang.add(_lessee.getLesseeNAME());
            hang.add(_lessee.getLesseeAGE());
            hang.add(_lessee.getlesseeMoney());
            hang.add(_lessee.getlesseetime());
            rowData.add(hang);
        }
        if(getRowCount()!=0){
            JOptionPane.showMessageDialog(jd, "һ����"+getRowCount()+"����¼��");
            return ;
        }else{
            JOptionPane.showMessageDialog(jd, "û���κμ�¼��");
            return ;
        }
    }

    //�õ����ж�����
    @Override
    public int getRowCount() {
        // TODO Auto-generated method stub
        return this.rowData.size();
    }
    //�õ����ж�����
    @Override
    public int getColumnCount() {
        // TODO Auto-generated method stub
        return this.columnNames.size();
    }
    //�õ�ĳ��ĳ�е�����
    @Override
    public Object getValueAt(int rowIndex, int columnIndex) {
        // TODO Auto-generated method stub
        return ((Vector)this.rowData.get(rowIndex)).get(columnIndex);
    }

    //��д���� getColumnName
    @Override
    public String getColumnName(int column) {
        // TODO Auto-generated method stub
        return (String)this.columnNames.get(column);
    }

}
