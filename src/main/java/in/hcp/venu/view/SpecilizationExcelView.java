package in.hcp.venu.view;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.usermodel.Sheet;
import org.apache.poi.ss.usermodel.Workbook;
import org.springframework.web.servlet.view.document.AbstractXlsxView;

import in.hcp.venu.entity.Specilazation;

public class SpecilizationExcelView extends AbstractXlsxView{

	@Override
	protected void buildExcelDocument(Map<String, Object> model,
			Workbook workbook,
			HttpServletRequest request,
			HttpServletResponse response) throws Exception {
		response.addHeader("content-disposition","attachment;filename=SPECS.xlsx");
		  @SuppressWarnings("unchecked")
		List<Specilazation> list=(List<Specilazation>)
				model.get("list");
		  Sheet sheet=workbook.createSheet("SPECILIZATION");
		  
	        setHead(sheet);
	        setBody(sheet,list);
	}

	private void setBody(Sheet sheet, List<Specilazation> list) {
		int rowNum=1;
		for(Specilazation spec:list) {
			Row row=sheet.createRow(rowNum++);
			row.createCell(0).setCellValue(spec.getId());
			row.createCell(1).setCellValue(spec.getCode());
			row.createCell(2).setCellValue(spec.getName());
			row.createCell(3).setCellValue(spec.getNote());
					
		}
		
	}

	private void setHead(Sheet sheet) {
	Row row=sheet.createRow(0);
	row.createCell(0).setCellValue("ID");
	row.createCell(1).setCellValue("CODE");
	row.createCell(2).setCellValue("NAME");
	row.createCell(3).setCellValue("NOTE");
	
		
	}

	
}
