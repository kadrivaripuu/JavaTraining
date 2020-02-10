package course.jse.jdbc.lab;

public class CdDaoDemo {

	public static void main(String[] args) {
		CdDao cdDao = new CdDao();
	
		
		Cd mockCd = new Cd();
		mockCd.setArtist("random Artist");
		mockCd.setCompany("random company" );
		mockCd.setCountry("random country");
		mockCd.setPrice(100.0);
		mockCd.setQuantity(2);
		mockCd.setTitle("Some title");
		mockCd.setVersion(1L);
		mockCd.setYear(2000);		
		
		
		cdDao.saveCd(mockCd);
		
		
		
		Cd foundByIdCd =cdDao.findById(58L);
		
		System.out.println("(FindId) Cd values: "+ foundByIdCd.toString());
		
		Cd foundByPriceCd =cdDao.findByPrice(8.9);
		
		System.out.println("(FindPrice) Cd values: "+ foundByPriceCd.toString());

		cdDao.deleteCd(10);
		
	
		
	}

}