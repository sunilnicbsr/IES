package com.ashokit.ies.ies.CO.Batch;

public interface CoGenDlyBatch {

	public boolean preProcess();

	public boolean postProcess();

	public boolean process();

	public boolean start();

}
