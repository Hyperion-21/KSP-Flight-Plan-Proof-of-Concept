package kspFlightPlan;

public class DVcompressor {
	
	public static int[] compress(DVarrayObject[] stageDVs) {
		int ascent = 0;
		int transfer = 0;
		int landing = 0;
		int ret = 0;
		int trivial = 0;
		
		for (DVarrayObject i : stageDVs) {
			switch (i.getRole()) {
				case 0: ascent += i.getDV(); 	break;
				case 1: transfer += i.getDV(); 	break;
				case 2: landing += i.getDV(); 	break;
				case 3: ret += i.getDV(); 		break;
				case 4: trivial += i.getDV(); 	break;
			}
		}
		int[] output = { ascent, transfer, landing, ret, trivial };
		return output;
	}

}
