package kr.or.bit.dao;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;


import kr.or.bit.dto.KoreaMember;
import kr.or.bit.utils.ConnectionHelper;

public class MemberDao{
/////상준 : 멤버리스트////////////////////////////////////////////////////////// 	
	 public ArrayList<KoreaMember> getMemberList() throws SQLException{
	        Connection conn = ConnectionHelper.getConnection("oracle");
	        
	        PreparedStatement pstmt = null;
	        String sql = "SELECT ID,IP FROM KOREAMEMBER";
	        pstmt = conn.prepareStatement(sql);
	        ResultSet rs = pstmt.executeQuery();
	        
	        ArrayList<KoreaMember> memberlist = new ArrayList<>();
	        while (rs.next()){
	            KoreaMember dto = new KoreaMember();
	            dto.setId(rs.getString("id"));
	            dto.setIp(rs.getString("ip"));
	            memberlist.add(dto);
	        }
	        ConnectionHelper.close(rs);
	        ConnectionHelper.close(pstmt);
	        ConnectionHelper.close(conn); //반환하기
	        
	        return memberlist;
	    }
    
/////예솔 : 회원가입////////////////////////////////////////////////////////// 
	public int joinMember(KoreaMember m) {
		Connection conn = null;
		int resultrow = 0;
		PreparedStatement pstmt = null;
		try {
			conn = ConnectionHelper.getConnection("oracle");// 추가

			String sql = "insert into koreaMember(id,pwd,name,age,gender,email,ip) values(?,?,?,?,?,?,?)";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, m.getId());
			pstmt.setString(2, m.getPwd());
			pstmt.setString(3, m.getName());
			pstmt.setInt(4, m.getAge());
			pstmt.setString(5, m.getGender());
			pstmt.setString(6, m.getEmail());
			pstmt.setString(7, m.getIp());

			resultrow = pstmt.executeUpdate();

		} catch (Exception e) {
			System.out.println("Insert : " + e.getMessage());
		} finally {
			ConnectionHelper.close(pstmt);
			ConnectionHelper.close(conn);
			try {
				conn.close(); // 받환하기
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return resultrow;
	}
/////////////////////////////////////////////////////////////
/////서정 : 로그인//////////////////////////////////////////////////////////	
	public KoreaMember loginMember(String id, String pwd) {
		Connection conn = ConnectionHelper.getConnection("oracle");
		KoreaMember koreaMember = null;
		ResultSet rs = null;
		PreparedStatement pstmt = null;

		try {
			//일단 주석 : conn = DriverManager.getConnection("jdbc:oracle:thin:@localhost:1521:XE", "bituser", "1004");

			String sql = "select id, pwd from koreaMember where id=? and pwd=?";
			pstmt = conn.prepareStatement(sql);
			pstmt.setString(1, id);
			pstmt.setString(2, pwd);
			rs = pstmt.executeQuery();

			if (rs.next()) {
				koreaMember = new KoreaMember();
				koreaMember.setId(rs.getString("id"));
				koreaMember.setPwd(rs.getString("pwd"));
			}
		} catch (Exception e) {
			System.out.println(e.getMessage());
		} finally {
			try {
				if (rs != null)
					rs.close();
				if (pstmt != null)
					pstmt.close();
			} catch (SQLException e) {
				e.printStackTrace();
			}
		}
		return koreaMember;
	}
//상준///////////////////////////////////////////////////////////
	 public int updateMember(KoreaMember m){
	        //update memo set email=? , content=? where id=?
	        //m.getId()
	        Connection conn = null;
	        PreparedStatement pstmt = null;
	        String sql = "";
	        int resultRow = 0;
	        
	        try{
	            conn = ConnectionHelper.getConnection("oracle");
	            sql = "UPDATE KOREAMEMBER SET NAME=? , AGE=? , GENDER=? , EMAIL = ? , IP = ? WHERE ID=?";
	            pstmt = conn.prepareStatement(sql);
	            pstmt.setString(1, m.getName());
	            pstmt.setInt(2, m.getAge());
	            pstmt.setString(3, m.getGender());
	            pstmt.setString(4, m.getEmail());
	            pstmt.setString(5, m.getIp());
	            pstmt.setString(6, m.getId());
	            resultRow = pstmt.executeUpdate();
	        }catch (Exception e){
	            System.out.println(e.getMessage());
	            
	        }finally{
	            ConnectionHelper.close(pstmt);
	            ConnectionHelper.close(conn);
	        }
	        return resultRow;
	    }
    
/////////////////////////////////////////////////////////////
/////지혜 : 삭제//////////////////////////////////////////////////////////	
    public int deleteMember(String id){
    	// delete from memo where id=?
    			Connection conn = null;// 추가
    			int resultrow = 0;
    			PreparedStatement pstmt = null;

    			try {
    				conn = ConnectionHelper.getConnection("oracle");// 추가

    				String sql = "delete from koreaMember where id=?";
    				pstmt = conn.prepareStatement(sql);
    				pstmt.setString(1, id);

    				resultrow = pstmt.executeUpdate();

    			} catch (Exception e) {
    				System.out.println("Delete : " + e.getMessage());
    			} finally {
    				ConnectionHelper.close(pstmt);
    				ConnectionHelper.close(conn);
    				try {
    					conn.close(); // 받환하기
    				} catch (SQLException e) {
    					e.printStackTrace();
    				}
    			}
    			return resultrow;
    			// return -1;//디비에러 ? //TODO 강사님의 뜻이 무엇일까..
    }
/////////////////////////////////////////////////////////////
    
    //추가함수 (ID 존재 유무 판단 함수)
    public String isCheckById(String id){
        
        //System.out.println("ismemoid : " + ismemoid);
        return null;
    }
    
    //멤버 상세 페이지
    public KoreaMember detailMember(String id){
        
        return null;
    }
    
//////////상준 ////////////////////////////////
    public KoreaMember getMemoListById(String id) throws SQLException{
        Connection conn = ConnectionHelper.getConnection("oracle");
        
        PreparedStatement pstmt = null;
        String sql = "SELECT ID,PWD,NAME,AGE,TRIM(GENDER),EMAIL FROM KOREAMEMBER WHERE ID=?";
        pstmt = conn.prepareStatement(sql);
        pstmt.setString(1, id);
        
        ResultSet rs = pstmt.executeQuery();
        KoreaMember dto = null;
        while (rs.next()){
            dto = new KoreaMember();
            dto.setId(rs.getString("id"));
            dto.setName(rs.getString("name"));
            dto.setEmail(rs.getString("email"));
            dto.setAge(rs.getInt("age"));
            dto.setGender(rs.getString("gender"));
            
        }
        ConnectionHelper.close(rs);
        ConnectionHelper.close(conn);
        ConnectionHelper.close(pstmt);
        
        return dto;
    }
///////상준/////////////////////////////////////////////
    public KoreaMember searchMemberByName(String name){
        Connection conn = null;
        PreparedStatement pstmt = null;
        ResultSet rs = null;
        KoreaMember dto = null;
        try{
            conn = ConnectionHelper.getConnection("oracle");
            String sql = "select id, name, email from koreamember where name like '%" + name + "%'";
            
            pstmt = conn.prepareStatement(sql);
            pstmt.setString(1, '%' + name + '%');
            rs = pstmt.executeQuery();
            if (rs.next()){
                dto = new KoreaMember();
                dto.setId(rs.getString("id"));
                dto.setName(rs.getString("name"));
                dto.setEmail(rs.getString("email"));
                
            }
         
            
        }catch (Exception e){
            System.out.println(e.getMessage());
        }finally{
            ConnectionHelper.close(rs);
            ConnectionHelper.close(conn);
            ConnectionHelper.close(pstmt);
            
        }
        //where ename like '%길동%'
        return dto;
    }
}






