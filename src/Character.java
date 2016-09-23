//package finals;

public class Character {
	//Add int's for each stat
	//prefix all with char to avoid issues with keywords (charName etc)
	//maybe an array for the inventory and skills.
	//may just add a class Skills with all the skills but that'll be a lot of stuff
	//might be better to add classes for each "class" (rogue, fighter etc) with the skills IN them and find a way to inherit those classes
	
	//Core stats
	private int charStr,charDex,charCon,charInt,charWis,charCha;
	//Other stats
	private int charAC,charInit,charInitMod,charSpeed;
	private int charExp, charExpToLevel, charLevel,charLevel2;
	private int charMaxHP,charCurHP,charTempHP;
	private int charDeathSuccess,charDeathFail;
	private int time;
	private int charSaveStrMod,charSaveDexMod,charSaveConMod,charSaveIntMod,charSaveWisMod,charSaveChaMod;
	private int charCopper,charSilver,charGold,charPlatinum,charElectrum;
	private int charHitDice;
	private Boolean inInitiative;
	private String charBackground,charPersonality,charIdeals,charBonds,charFlaws,charName;
	private String timeType,moveType;
	
		private String charClass; //maybe make ENUM
	//	private String charClass2; //just in case
		private String charRace; //maybe make ENUM
	//	private String charAlignment; //maybe make ENUM
	
	public Character(){
		
	}
	
	/**
	 * @return the charStr
	 */
	public int getCharStr() {
		return charStr;
	}

	/**
	 * @param charStr the charStr to set
	 */
	public void setCharStr(int charStr) {
		this.charStr = charStr;
	}

	/**
	 * @return the charDex
	 */
	public int getCharDex() {
		return charDex;
	}

	/**
	 * @param charDex the charDex to set
	 */
	public void setCharDex(int charDex) {
		this.charDex = charDex;
	}

	/**
	 * @return the charCon
	 */
	public int getCharCon() {
		return charCon;
	}

	/**
	 * @param charCon the charCon to set
	 */
	public void setCharCon(int charCon) {
		this.charCon = charCon;
	}

	/**
	 * @return the charInt
	 */
	public int getCharInt() {
		return charInt;
	}

	/**
	 * @param charInt the charInt to set
	 */
	public void setCharInt(int charInt) {
		this.charInt = charInt;
	}

	/**
	 * @return the charWis
	 */
	public int getCharWis() {
		return charWis;
	}

	/**
	 * @param charWis the charWis to set
	 */
	public void setCharWis(int charWis) {
		this.charWis = charWis;
	}

	/**
	 * @return the charCha
	 */
	public int getCharCha() {
		return charCha;
	}

	/**
	 * @param charCha the charCha to set
	 */
	public void setCharCha(int charCha) {
		this.charCha = charCha;
	}

	/**
	 * @return the charAC
	 */
	public int getCharAC() {
		return charAC;
	}

	/**
	 * @param charAC the charAC to set
	 */
	public void setCharAC(int charAC) {
		this.charAC = charAC;
	}

	/**
	 * @return the charInit
	 */
	public int getCharInit() {
		return charInit;
	}

	/**
	 * @param charInit the charInit to set
	 */
	public void setCharInit(int charInit) {
		this.charInit = charInit;
	}

	/**
	 * @return the charInitMod
	 */
	public int getCharInitMod() {
		return charInitMod;
	}

	/**
	 * @param charInitMod the charInitMod to set
	 */
	public void setCharInitMod(int charInitMod) {
		this.charInitMod = charInitMod;
	}

	/**
	 * @return the charSpeed
	 */
	public int getCharSpeed() {
		return charSpeed;
	}

	/**
	 * @param charSpeed the charSpeed to set
	 */
	public void setCharSpeed(int charSpeed) {
		this.charSpeed = charSpeed;
	}

	/**
	 * @return the charExp
	 */
	public int getCharExp() {
		return charExp;
	}

	/**
	 * @param charExp the charExp to set
	 */
	public void setCharExp(int charExp) {
		this.charExp = charExp;
	}

	/**
	 * @return the charLevel
	 */
	public int getCharLevel() {
		return charLevel;
	}

	/**
	 * @param charLevel the charLevel to set
	 */
	public void setCharLevel(int charLevel) {
		this.charLevel = charLevel;
	}

	/**
	 * @return the charLevel2
	 */
	public int getCharLevel2() {
		return charLevel2;
	}

	/**
	 * @param charLevel2 the charLevel2 to set
	 */
	public void setCharLevel2(int charLevel2) {
		this.charLevel2 = charLevel2;
	}

	/**
	 * @return the charMaxHP
	 */
	public int getCharMaxHP() {
		return charMaxHP;
	}

	/**
	 * @param charMaxHP the charMaxHP to set
	 */
	public void setCharMaxHP(int charMaxHP) {
		this.charMaxHP = charMaxHP;
	}

	/**
	 * @return the charCurHP
	 */
	public int getCharCurHP() {
		return charCurHP;
	}

	/**
	 * @param charCurHP the charCurHP to set
	 */
	public void setCharCurHP(int charCurHP) {
		this.charCurHP = charCurHP;
	}

	/**
	 * @return the charTempHP
	 */
	public int getCharTempHP() {
		return charTempHP;
	}

	/**
	 * @param charTempHP the charTempHP to set
	 */
	public void setCharTempHP(int charTempHP) {
		this.charTempHP = charTempHP;
	}

	/**
	 * @return the charDeathSuccess
	 */
	public int getCharDeathSuccess() {
		return charDeathSuccess;
	}

	/**
	 * @param charDeathSuccess the charDeathSuccess to set
	 */
	public void setCharDeathSuccess(int charDeathSuccess) {
		this.charDeathSuccess = charDeathSuccess;
	}

	/**
	 * @return the charDeathFail
	 */
	public int getCharDeathFail() {
		return charDeathFail;
	}

	/**
	 * @param charDeathFail the charDeathFail to set
	 */
	public void setCharDeathFail(int charDeathFail) {
		this.charDeathFail = charDeathFail;
	}

	/**
	 * @return the time
	 */
	public int getTime() {
		return time;
	}

	/**
	 * @param time the time to set
	 */
	public void setTime(int time) {
		this.time = time;
	}

	/**
	 * @return the charSaveStrMod
	 */
	public int getCharSaveStrMod() {
		return charSaveStrMod;
	}

	/**
	 * @param charSaveStrMod the charSaveStrMod to set
	 */
	public void setCharSaveStrMod(int charSaveStrMod) {
		this.charSaveStrMod = charSaveStrMod;
	}

	/**
	 * @return the charSaveDexMod
	 */
	public int getCharSaveDexMod() {
		return charSaveDexMod;
	}

	/**
	 * @param charSaveDexMod the charSaveDexMod to set
	 */
	public void setCharSaveDexMod(int charSaveDexMod) {
		this.charSaveDexMod = charSaveDexMod;
	}

	/**
	 * @return the charSaveConMod
	 */
	public int getCharSaveConMod() {
		return charSaveConMod;
	}

	/**
	 * @param charSaveConMod the charSaveConMod to set
	 */
	public void setCharSaveConMod(int charSaveConMod) {
		this.charSaveConMod = charSaveConMod;
	}

	/**
	 * @return the charSaveIntMod
	 */
	public int getCharSaveIntMod() {
		return charSaveIntMod;
	}

	/**
	 * @param charSaveIntMod the charSaveIntMod to set
	 */
	public void setCharSaveIntMod(int charSaveIntMod) {
		this.charSaveIntMod = charSaveIntMod;
	}

	/**
	 * @return the charSaveWisMod
	 */
	public int getCharSaveWisMod() {
		return charSaveWisMod;
	}

	/**
	 * @param charSaveWisMod the charSaveWisMod to set
	 */
	public void setCharSaveWisMod(int charSaveWisMod) {
		this.charSaveWisMod = charSaveWisMod;
	}

	/**
	 * @return the charSaveChaMod
	 */
	public int getCharSaveChaMod() {
		return charSaveChaMod;
	}

	/**
	 * @param charSaveChaMod the charSaveChaMod to set
	 */
	public void setCharSaveChaMod(int charSaveChaMod) {
		this.charSaveChaMod = charSaveChaMod;
	}

	/**
	 * @return the charCopper
	 */
	public int getCharCopper() {
		return charCopper;
	}

	/**
	 * @param charCopper the charCopper to set
	 */
	public void setCharCopper(int charCopper) {
		this.charCopper = charCopper;
	}

	/**
	 * @return the charSilver
	 */
	public int getCharSilver() {
		return charSilver;
	}

	/**
	 * @param charSilver the charSilver to set
	 */
	public void setCharSilver(int charSilver) {
		this.charSilver = charSilver;
	}

	/**
	 * @return the charGold
	 */
	public int getCharGold() {
		return charGold;
	}

	/**
	 * @param charGold the charGold to set
	 */
	public void setCharGold(int charGold) {
		this.charGold = charGold;
	}

	/**
	 * @return the charPlatinum
	 */
	public int getCharPlatinum() {
		return charPlatinum;
	}

	/**
	 * @param charPlatinum the charPlatinum to set
	 */
	public void setCharPlatinum(int charPlatinum) {
		this.charPlatinum = charPlatinum;
	}

	/**
	 * @return the charElectrum
	 */
	public int getCharElectrum() {
		return charElectrum;
	}

	/**
	 * @param charElectrum the charElectrum to set
	 */
	public void setCharElectrum(int charElectrum) {
		this.charElectrum = charElectrum;
	}

	/**
	 * @return the charHitDice
	 */
	public int getCharHitDice() {
		return charHitDice;
	}

	/**
	 * @param charHitDice the charHitDice to set
	 */
	public void setCharHitDice(int charHitDice) {
		this.charHitDice = charHitDice;
	}

	/**
	 * @return the inInitiative
	 */
	public Boolean getInInitiative() {
		return inInitiative;
	}

	/**
	 * @param inInitiative the inInitiative to set
	 */
	public void setInInitiative(Boolean inInitiative) {
		this.inInitiative = inInitiative;
	}

	/**
	 * @return the charBackground
	 */
	public String getCharBackground() {
		return charBackground;
	}

	/**
	 * @param charBackground the charBackground to set
	 */
	public void setCharBackground(String charBackground) {
		this.charBackground = charBackground;
	}

	/**
	 * @return the charPersonality
	 */
	public String getCharPersonality() {
		return charPersonality;
	}

	/**
	 * @param charPersonality the charPersonality to set
	 */
	public void setCharPersonality(String charPersonality) {
		this.charPersonality = charPersonality;
	}

	/**
	 * @return the charIdeals
	 */
	public String getCharIdeals() {
		return charIdeals;
	}

	/**
	 * @param charIdeals the charIdeals to set
	 */
	public void setCharIdeals(String charIdeals) {
		this.charIdeals = charIdeals;
	}

	/**
	 * @return the charBonds
	 */
	public String getCharBonds() {
		return charBonds;
	}

	/**
	 * @param charBonds the charBonds to set
	 */
	public void setCharBonds(String charBonds) {
		this.charBonds = charBonds;
	}

	/**
	 * @return the charFlaws
	 */
	public String getCharFlaws() {
		return charFlaws;
	}

	/**
	 * @param charFlaws the charFlaws to set
	 */
	public void setCharFlaws(String charFlaws) {
		this.charFlaws = charFlaws;
	}

	/**
	 * @return the charName
	 */
	public String getCharName() {
		return charName;
	}

	/**
	 * @param charName the charName to set
	 */
	public void setCharName(String charName) {
		this.charName = charName;
	}

	/**
	 * @return the timeType
	 */
	public String getTimeType() {
		return timeType;
	}

	/**
	 * @param timeType the timeType to set
	 */
	public void setTimeType(String timeType) {
		this.timeType = timeType;
	}

	/**
	 * @return the moveType
	 */
	public String getMoveType() {
		return moveType;
	}

	/**
	 * @param moveType the moveType to set
	 */
	public void setMoveType(String moveType) {
		this.moveType = moveType;
	}
	/**
	 * @return the moveType
	 */
	public String getCharRace() {
		return charRace;
	}

	/**
	 * @param moveType the moveType to set
	 */
	public void setCharRace(String charRace) {
		this.charRace = charRace;
	}
	/**
	 * @return the moveType
	 */
	public String getCharClass() {
		return charClass;
	}

	/**
	 * @param moveType the moveType to set
	 */
	public void setCharClass(String charClass) {
		this.charClass = charClass;
	}
}