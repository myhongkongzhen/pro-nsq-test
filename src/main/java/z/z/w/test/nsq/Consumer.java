package z.z.w.test.nsq;

import ly.bit.nsq.Message;
import ly.bit.nsq.exceptions.NSQException;
import ly.bit.nsq.syncresponse.SyncResponseHandler;
import ly.bit.nsq.syncresponse.SyncResponseReader;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**************************************************************************
 * <pre>
 *     FileName: z.z.w.test.nsq.Consumer.java
 *         Desc:
 *      @author: Z_Z.W - myhongkongzhen@gmail.com
 *     @version: 2015年8月31日 上午11:31:28
 *   LastChange: 2015年8月31日 上午11:31:28
 *      History:
 * </pre>
 **************************************************************************/
public class Consumer implements SyncResponseHandler
{
	final static Logger logger = LoggerFactory.getLogger( Consumer.class );

	public static void main( String[] args )
	{
		// http://101.200.188.159:4151/pub?topic=native_nsq_api_pub_test
		SyncResponseHandler sh = new Consumer();
		SyncResponseReader reader = new SyncResponseReader( "native_nsq_api_pub_test", "native_nsq_api_pub_test ", sh );
		try
		{
			reader.connectToNsqd( "101.200.188.159", 4151 );
		}
		catch ( NSQException e )
		{
			logger.error( "Consumer error : [{}].", e.getMessage(), e );
		}
	}

	/*
	 * (non-Javadoc)
	 * @see ly.bit.nsq.syncresponse.SyncResponseHandler#handleMessage(ly.bit.nsq.Message)
	 */
	public boolean handleMessage( Message msg ) throws NSQException
	{
		try
		{
			logger.info( "Consumer:{}. ", new String( msg.getBody(), "utf-8" ) );
		}
		catch ( Exception e )
		{
			logger.error( "conversion string error : {}", e.getMessage(), e );
		}
		return true;
	}
}
