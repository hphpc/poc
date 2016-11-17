package com.esd.e2faas;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.nio.MappedByteBuffer;
import java.nio.channels.FileChannel;
import java.nio.charset.Charset;
import java.util.List;

import com.google.common.io.ByteSource;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.opengamma.strata.loader.fpml.FpmlDocumentParser;
import com.opengamma.strata.loader.fpml.FpmlPartySelector;
import com.opengamma.strata.product.Trade;
import com.opengamma.strata.product.fx.FxSingle;
import com.opengamma.strata.product.fx.FxSingleTrade;

public class Service {

	public static void main(String[] args) {
		
		int payloadPos = -1;
		for( int i=0; i < args.length; i ++ ) {
			if (args[i].equals("-payload")) {
				payloadPos = i +1;
				break;
			}
		}
		if (payloadPos >= args.length) {
			System.err.println("Invalid payload argument");
			System.exit(1);
		}
		if (payloadPos == -1) {
			System.err.println("No payload argument");
			System.exit(1);
		}
		
		String payload = "";
		try {
			payload = readFile(args[payloadPos]);
		} catch (IOException e) {
			System.err.println("IOException");
            System.exit(1);
		}
		ByteSource resource = ByteSource.wrap( payload.getBytes() );
		List<Trade> trades = FpmlDocumentParser.of(FpmlPartySelector.matching("Party1")).parseTrades(resource);
		FxSingleTrade fxTrade = (FxSingleTrade) trades.get(0);
		FxSingle fx = fxTrade.getProduct();
		Gson gson = new GsonBuilder().setPrettyPrinting().create();
		String json = gson.toJson(fxTrade);
		if ( fx != null ) {
			System.out.println(json);
		}
	}

	private static String readFile(String path) throws IOException {
		FileInputStream stream = new FileInputStream(new File(path));
		try {
			FileChannel channel = stream.getChannel();
			MappedByteBuffer buf = channel.map(FileChannel.MapMode.READ_ONLY, 0, channel.size());
			return Charset.defaultCharset().decode(buf).toString();
		} finally {
			stream.close();
		}
	}

}
