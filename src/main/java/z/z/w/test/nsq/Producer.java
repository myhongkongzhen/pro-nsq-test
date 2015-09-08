package z.z.w.test.nsq ;

import ly.bit.nsq.NSQProducer ;

import org.slf4j.Logger ;
import org.slf4j.LoggerFactory ;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.nsq.Producer.java
 *         Desc: 
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月31日 上午11:32:58 
 *   LastChange: 2015年8月31日 上午11:32:58 
 *      History:
 * </pre>
 **************************************************************************/
public class Producer
{
	final static Logger	logger	= LoggerFactory.getLogger( Producer.class ) ;
	
	public static void main( String[] args )
	{
		NSQProducer producer = new NSQProducer( "http://101.200.188.159:4151", "native_nsq_api_pub_test" ) ;
//		int i = 0 ;
//		while ( true )
		for ( int i = 0 ; i < 1000 ; i++ )
		{
			String message = "{\"foo\":\"bar_" + i++ + "\"}" ;
			logger.info( "{}", message ) ;
			producer.putAsync( message ) ;
		}
		
		producer.shutdown() ;
	}
}
