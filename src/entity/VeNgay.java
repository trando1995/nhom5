package entity;
// TODO: Auto-generated Javadoc

/**
 * tạo thông tin vé ngày
 * khởi tạo các giá trị .
 *
 * @author duonganh
 */
public class VeNgay {
	
	/** The id. */
	private String id;
	
	/** The loaixe. */
	private String loaixe;
	
	/**
	 * Gets the id.
	 *
	 * @return the id
	 */
	public String getId() {
		return id;
	}
	
	/**
	 * Sets the id.
	 *
	 * @param id the id to set
	 */
	public void setId(String id) {
		this.id = id;
	}
	
	/**
	 * Gets the loaixe.
	 *
	 * @return the loaixe
	 */
	public String getLoaixe() {
		return loaixe;
	}
	
	/**
	 * Sets the loaixe.
	 *
	 * @param loaixe the loaixe to set
	 */
	public void setLoaixe(String loaixe) {
		this.loaixe = loaixe;
	}
	
	/**
	 * Instantiates a new ve ngay.
	 *
	 * @param id mã vé ngày
	 * @param loaixe loại xe
	 */
	public VeNgay(String id, String loaixe) {
		super();
		this.id = id;
		this.loaixe = loaixe;
	}
	
	/**
	 * Instantiates a new ve ngay.
	 */
	public VeNgay() {
		super();
		// TODO Auto-generated constructor stub
	}
}
