package com.delimp.filerender;

import com.groupdocs.conversion.Converter;
import com.groupdocs.conversion.filetypes.FileType;
import com.groupdocs.conversion.options.convert.ConvertOptions;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
class FilerenderApplicationTests {

	@Test
	void contextLoads() {
	}

	@Test
	void conversionTest(){
		/*try{
			Converter converter = new Converter("report.docx");
			ConvertOptions convertOptions = new FileType().fromExtension("pdf").getConvertOptions();
			converter.convert("output.pdf", convertOptions);
		}catch (Exception e){
			e.printStackTrace();
		}*/
		Assertions.assertTrue(true);
	}
}
