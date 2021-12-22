package mybatis.config;

import java.io.FileNotFoundException;
import java.io.IOException;
import java.io.Reader;

import org.apache.ibatis.io.Resources;
import org.apache.ibatis.session.SqlSessionFactory;
import org.apache.ibatis.session.SqlSessionFactoryBuilder;

import com.book.book.vo.IgPostVO;

public class MyBatisConnectionFactory {
	
	private static SqlSessionFactory sqlSessionFactory;
	 
    static {
        try {
            String resource = "mybatis/config/mybatis-config.xml";
            
            Reader reader = Resources.getResourceAsReader(resource);
 
            if (sqlSessionFactory == null) {
                sqlSessionFactory = new SqlSessionFactoryBuilder().build(reader);
            }
        }
        catch (FileNotFoundException fileNotFoundException) {
            fileNotFoundException.printStackTrace();
        }
        catch (IOException iOException) {
            iOException.printStackTrace();
        }
    }
    public static SqlSessionFactory getSqlSessionFactory() {
        return sqlSessionFactory;
    }
//    public static void main(String[] args) {
//    	IgPostVO post = new IgPostVO();
//		System.out.println(getSqlSessionFactory().openSession(false).insert("IgPost.insert",post));
//	}
}
