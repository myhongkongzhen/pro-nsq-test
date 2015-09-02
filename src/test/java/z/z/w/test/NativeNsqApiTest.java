package z.z.w.test ;

import org.junit.Ignore ;
import org.junit.Test ;
import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

import z.z.w.util.http.HttpClientUtil ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.NativeNsqApiTest.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年9月2日 下午2:21:24 
 *   LastChange: 2015年9月2日 下午2:21:24 
 *      History:
 * </pre>
 **************************************************************************/
public class NativeNsqApiTest
{
	final static Logger	logger	= LoggerFactory.getLogger( NativeNsqApiTest.class ) ;
	
	@Test
	@Ignore
	public void testLookup()
	{
		try
		{
			String path = "native_nsq_api_topic_create_test" ;
			String url = "http://101.200.188.159:4151/topics" ;
			logger.info( "{}", HttpClientUtil.httpPost( url ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	@Test
	@Ignore
	public void testPing()
	{
		try
		{
			String path =
//			
			"debug/pprof/threadcreate" ;
//			"debug/pprof/block" ;
//			"debug/pprof/heap" ;
//			"debug/pprof/goroutine" ;
//			"debug/pprof/profile" ;
//			"debug/pprof" ;
//			"ping" ;
//			"info" ;
			String url = "http://101.200.188.159:4151/" + path ;
			logger.info( "{}", HttpClientUtil.httpPost( url ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	@Test
	@Ignore
	public void testStats()
	{
		try
		{
			String url = "http://101.200.188.159:4151/stats?format=json" ;
			logger.info( "{}", HttpClientUtil.httpPost( url ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	/**
	 * topic/create - 创建一个新的话题（topic)
	 * topic/delete - 删除一个话题（topic)
	 * topic/empty - 清空话题（topic)
	 * topic/pause - 暂停话题（topic)的消息流
	 * topic/unpause - 恢复话题（topic)的消息流
	 * channel/create - 创建一个新的通道（channel)
	 * channel/delete - 删除一个通道（channel)
	 * channel/empty - 清空一个通道（channel)
	 * channel/pause - 暂停通道（channel)的消息流
	 * channel/unpause - 恢复通道（channel)的消息流
	 * Create by : 2015年9月2日 下午3:07:17
	 */
	@Test
	@Ignore
	public void testChannelCreate()
	{
		try
		{
			String msg = "native_nsq_api_topic_create_test" ;
			String url = "http://101.200.188.159:4151/channel/create?topic=" + msg + "&channel=" + msg ;
			logger.info( "{}", HttpClientUtil.httpPost( url ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	@Test
	@Ignore
	public void testTopicCreate()
	{
		try
		{
			String msg = "native_nsq_api_topic_create_test" ;
			String url = "http://101.200.188.159:4151/topic/create?topic=" + msg ;
			logger.info( "{}", HttpClientUtil.httpPost( url ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	@Test
	@Ignore
	public void testMpub()
	{
		try
		{
			String msg = "這是一個使用原生NSQ API做的發送測試\n1\n2\n3\n4" ;
			String url = "http://101.200.188.159:4151/mpub?topic=native_nsq_api_topic_create_test" ;
			logger.info( "{}", HttpClientUtil.httpPost( url, msg ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
	
	@Test
	@Ignore
	public void testPub()
	{
		try
		{
			String msg = "這是一個使用原生NSQ API做的發送測試" ;
			String url = "http://101.200.188.159:4151/pub?topic=native_nsq_api_pub_test" ;
			logger.info( "{}", HttpClientUtil.httpPost( url, msg ) ) ; ;
		}
		catch ( Exception e )
		{
			logger.error( "NativeNsqApiTest testPub error : [{}].", e.getMessage(), e ) ;
		}
	}
}
