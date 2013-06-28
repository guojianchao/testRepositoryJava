package isearch.analyzer;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;
import java.io.Reader;

import net.paoding.analysis.analyzer.PaodingAnalyzer;

import org.apache.lucene.analysis.Analyzer;
import org.apache.lucene.document.Document;
import org.apache.lucene.document.Field;
import org.apache.lucene.index.CorruptIndexException;
import org.apache.lucene.index.IndexWriter;
import org.apache.lucene.queryParser.ParseException;
import org.apache.lucene.queryParser.QueryParser;
import org.apache.lucene.search.IndexSearcher;
import org.apache.lucene.search.Query;
import org.apache.lucene.search.ScoreDoc;
import org.apache.lucene.search.TopDocs;
import org.apache.lucene.store.Directory;
import org.apache.lucene.store.FSDirectory;
import org.apache.lucene.store.LockObtainFailedException;
import org.apache.lucene.util.Version;
public class SimpleAnalzer {
	//Analyzer analyzer = new PaodingAnalyzer();
	
	
	/**
	 *  content�ļ��д��������ļ����ļ����ݷֱ���
	 *  1�����ʶ�С��س�����Ļ����ǰȫ�ӱض�֪���͹��»�
	 *  2��CWSS��һ����Դ�ģ�����java���Կ����������������ķִʹ��߰�,���ṩ��lucene3.0��֧�֡�Ŀǰ���ڲ��Խ׶�,�ݲ���Դ����.�������. ����GPL��ԴЭ�鷢��.
	 *  3�����籭���������
	 */
	private String getString(Reader input) throws IOException{
		BufferedReader buf;
		buf = new BufferedReader(input);
		String str;
		StringBuffer sb = new StringBuffer();
		while ((str = buf.readLine()) != null) {        
			sb.append(str);    
	    }
		str = sb.toString();
		sb = null;
		return str;
	}
	
	private void index() throws CorruptIndexException, LockObtainFailedException, IOException{
		 File indexDir=new File("D:/luceneIndex/");  
		 //��Ҫ�����������ĵ����ϵ�λ��  
		  File docDir = new File("D:/content/");   
		 //����������(����)  
		  Analyzer analyzer = new PaodingAnalyzer();
		  IndexWriter standardWriter = new IndexWriter(FSDirectory.open(indexDir), analyzer, true , IndexWriter.MaxFieldLength.LIMITED);//new IndexWriter(FSDirectory.open(indexDir),analyzer, true, IndexWriter.MaxFieldLength.LIMITED);           
		 //����������ʽ�����ļ���Ĭ�ϵ�������Ǹ���ʽ�������ļ�  
		 standardWriter.setUseCompoundFile(false);  
		 //Ϊԭ�ĵ������е�ÿ���ĵ��������Ϣ��������  
		 for (File fileSrc : docDir.listFiles()) {     
		         //Lucene���ĵ��ṹ  
		         Document doc = new Document();                       
		         //�ļ����ƣ��ɲ�ѯ�����ִ�  
		         String fileName=fileSrc.getName().substring(0,fileSrc.getName().indexOf("."));
		         doc.add(new Field("name",fileName, Field.Store.YES, Field.Index.NOT_ANALYZED));    
		          //�ļ�·�����ɲ�ѯ�����ִ�  
		         String filePath=fileSrc.getPath();  
		         doc.add(new Field("path", filePath, Field.Store.YES, Field.Index.NOT_ANALYZED));  
		         //�ļ����ݣ���Ҫ����
		         doc.add(new Field("content", getString(new FileReader(fileSrc)),Field.Store.YES,Field.Index.ANALYZED));              
		         //ʹ����������Document�ĵ�������  
		        standardWriter.addDocument(doc);    
		 }    
		 //�ر�����������д����������ļ�  
		 standardWriter.optimize();    
		 standardWriter.close();  
	}
	
	public String search(String keyword){
//		File indexDir=new File("D:/luceneIndex/"); 
//		Directory directory;
//		IndexSearcher isearcher = null;
//		//ʵ����������   
		try {
//			directory = FSDirectory.open(indexDir);
//			isearcher = new IndexSearcher(directory);
			Analyzer analyzer = new PaodingAnalyzer();
			
			//��������ֽ��зִ�//
			QueryParser parser = new QueryParser(Version.LUCENE_CURRENT, "",
					analyzer);
			//ʹ��IKQueryParser��ѯ����������Query����
			Query query = parser.parse(keyword);
			
			//�������ƶ���ߵ�5����¼
			System.out.println(query);
			
			
			
			
			
//			TopDocs topDocs = isearcher.search(query, 2);
//			System.out.println("���У�" + topDocs.totalHits);
//			//������
//			ScoreDoc[] scoreDocs = topDocs.scoreDocs;
//			for (int i = 0; i < topDocs.totalHits; i++){
//				Document targetDoc = isearcher.doc(scoreDocs[i].doc);
//				System.out.println("���ݣ�" + targetDoc.toString());
//			}
			return query.toString();
		}  catch (Exception e) {
			// TODO Auto-generated catch block
			 e.printStackTrace();
		}
		return null;
	}
	public static void main(String[] args) throws IOException {
		SimpleAnalzer lucene = new SimpleAnalzer();
		//lucene.index();
		lucene.search("�й����»�");

	}
	
//  �������������������
//	���У�1
//	���ݣ�Document<stored,indexed<name:2> stored,indexed<path:D:/content/2.txt> stored,indexed,tokenized<content:CWSS��һ����Դ�ģ�����java���Կ����������������ķִʹ��߰�,���ṩ��lucene3.0��֧�֡�Ŀǰ���ڲ��Խ׶�,�ݲ���Դ����.�������. ����GPL��ԴЭ�鷢��.>>
//	���У�2
//	���ݣ�Document<stored,indexed<name:3> stored,indexed<path:D:/content/3.txt> stored,indexed,tokenized<content:���籭���������>>
//	���ݣ�Document<stored,indexed<name:1> stored,indexed<path:D:/content/1.txt> stored,indexed,tokenized<content:���ʶ�С��س�����Ļ����ǰȫ�ӱض�֪���͹��»�>>

}
