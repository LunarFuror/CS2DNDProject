
public class Item {
	private String itemName;
	private String itemType;
	private int itemAmount;
	private boolean isEquipped;
	
	public Item(){
		setItemName("N/A");
		setItemType("N/A");
		setItemAmount(0);
		setIsEquipped(false);
	}
	
	public Item(String iName, String iType, int iAmount, boolean iEquipped){
		setItemName(iName);
		setItemType(iType);
		setItemAmount(iAmount);
		setIsEquipped(iEquipped);
	}
	
	/**
	 * @return the itemName
	 */
	public String getItemName() {
		return itemName;
	}
	/**
	 * @param itemName the itemName to set
	 */
	public void setItemName(String itemName) {
		this.itemName = itemName;
	}
	/**
	 * @return the itemType
	 */
	public String getItemType() {
		return itemType;
	}
	/**
	 * @param itemType the itemType to set
	 */
	public void setItemType(String itemType) {
		this.itemType = itemType;
	}
	/**
	 * @return the itemAmount
	 */
	public int getItemAmount() {
		return itemAmount;
	}
	/**
	 * @param itemAmount the itemAmount to set
	 */
	public void setItemAmount(int itemAmount) {
		this.itemAmount = itemAmount;
	}
	/**
	 * @return the isEquipped
	 */
	public boolean getIsEquipped() {
		return isEquipped;
	}
	/**
	 * @param isEquipped the isEquipped to set
	 */
	public void setIsEquipped(boolean isEquipped) {
		this.isEquipped = isEquipped;
	}
 	
}
