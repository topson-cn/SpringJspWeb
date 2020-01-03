package com.panda.SpringJspWeb.kt;

import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;

import java.util.concurrent.*;

public class ThreadPoolUtil {

	private static final Log log = LogFactory.getLog(ThreadPoolUtil.class);


	private static final ExecutorService threadPoolExecutor =
			new ThreadPoolExecutor(
					16,
					32,
					30, TimeUnit.SECONDS,
					new ArrayBlockingQueue<Runnable>(2000),
					new RejectedExecutionHandler() {
						@Override
						public void rejectedExecution(Runnable r, ThreadPoolExecutor executor) {
							log.info("execute sync, detail: " + threadPoolExecutor.toString());
							if (!executor.isShutdown()) {
								r.run();
							}
						}
					});

	public static void execute(Runnable runnable) {
		threadPoolExecutor.execute(runnable);
	}




}
