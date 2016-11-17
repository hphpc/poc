package com.esd.e2faas;

/**
 * Simple Trade processor
 *
 */
public class App 
{
//	public static String JsonConvertor( String[] args ) {
//		String inputData = null;
//		StringBuilder builder = new StringBuilder();
//		ByteSource resource = null;
//
//		if (args.length <= 0 ) {
//			System.err.println("There needs to be ONE input argument and that should be FpML input string for a trade. Got " + args.length + " arguments");
//			System.exit(1);
//		} else if ( args.length == 2 && args[0].equalsIgnoreCase("-f")) {
//			BufferedReader rd = null;
//			String inputLine  = null;
//			try {
//				rd = new BufferedReader(new FileReader(args[1]));
//				while ( ( inputLine = rd.readLine() ) != null )
//					builder.append( inputLine);
//			} catch (FileNotFoundException e) {
//				e.printStackTrace();
//			} catch (IOException e) {
//				e.printStackTrace();
//			} finally {
//				try {
//					if (rd != null)
//						rd.close();
//				} catch (IOException ex) {
//					ex.printStackTrace();
//				}
//			}
//			inputData = builder.toString();
//		} else {
//			for ( String s : args ) {
//				builder.append(s).append( " ");
//			}
//			inputData = builder.toString();
//		}
//
//		resource = ByteSource.wrap( inputData.getBytes() );
//		List<Trade> trades = FpmlDocumentParser.of(FpmlPartySelector.matching("Party1")).parseTrades(resource);
//		Trade trade = trades.get(0);
//		FxSingleTrade fxTrade = (FxSingleTrade) trade;
//		FxSingle fx = fxTrade.getProduct();
//		Gson gson = new GsonBuilder().setPrettyPrinting().create();
//		String json = gson.toJson(fxTrade);
//		if ( fx != null ) {
//			System.out.println(json);
//		}
//		return json;
//	}
}
