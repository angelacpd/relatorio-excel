package br.ufsc.das;

import java.io.ByteArrayOutputStream;
import java.io.IOException;
import java.util.List;

import org.apache.poi.hssf.usermodel.HSSFCell;
import org.apache.poi.hssf.usermodel.HSSFCellStyle;
import org.apache.poi.hssf.usermodel.HSSFFont;
import org.apache.poi.hssf.usermodel.HSSFRichTextString;
import org.apache.poi.hssf.usermodel.HSSFRow;
import org.apache.poi.hssf.usermodel.HSSFSheet;
import org.apache.poi.hssf.usermodel.HSSFWorkbook;
import org.apache.poi.hssf.util.HSSFColor;

public class GerarRelatorio {

	public byte[] gerarRelatorioExcel(List<Pedido> pedidos) throws IOException {

		// Criando relatorio em Excel

		HSSFWorkbook wb = null;

		try {
			// Criando um "workbook" (pode ter varias planilhas)
			wb = new HSSFWorkbook();

			// Criando uma planilha
			HSSFSheet sheet = wb.createSheet();

			// Definindo os estilos do relatorio
			HSSFCellStyle styleHeader = getEstiloCabecalho(wb);
			HSSFCellStyle styleCell = getEstiloCelula(wb);

			// Cabecalho

			String[] nomesColunasCabecalho = new String[] { "Código", "Cliente", "Endereço", "Estado", "Itens do Reator", "Itens do Robo" };

			HSSFRow cabecalho = sheet.createRow((short) 0);

			int j = 0;

			for (String s : nomesColunasCabecalho) {
				HSSFRichTextString text = new HSSFRichTextString(s);

				HSSFCell cell = cabecalho.createCell(j);
				cell.setCellValue(text);
				cell.setCellStyle(styleHeader);
				j++;
			}

			// Linhas
			// O indice começa em 0, 1 indica a segunda linha (a primeira após o cabeçalho)
			int i = 1;

			for (Pedido p : pedidos) {

				HSSFRow linha = sheet.createRow((short) i++);

				j = 0;

				// Codigo
				HSSFCell coluna1 = linha.createCell(j++);
				coluna1.setCellValue(new HSSFRichTextString(String.valueOf(p.getCodigo())));
				coluna1.setCellStyle(styleCell);

				// Cliente
				HSSFCell coluna2 = linha.createCell(j++);
				coluna2.setCellValue(new HSSFRichTextString(p.getCliente()));
				coluna2.setCellStyle(styleCell);

				// Endereco
				HSSFCell coluna3 = linha.createCell(j++);
				coluna3.setCellValue(new HSSFRichTextString(p.getEndereco()));
				coluna3.setCellStyle(styleCell);

				// Estado
				HSSFCell coluna4 = linha.createCell(j++);
				coluna4.setCellValue(new HSSFRichTextString(p.getEstado()));
				coluna4.setCellStyle(styleCell);

				// Itens do Reator
				HSSFCell coluna5 = linha.createCell(j++);
				coluna5.setCellValue(new HSSFRichTextString(p.getItensReator()));
				coluna5.setCellStyle(styleCell);

				// Itens do Robo
				HSSFCell coluna6 = linha.createCell(j++);
				coluna6.setCellValue(new HSSFRichTextString(p.getItensRobos()));
				coluna6.setCellStyle(styleCell);

			}

			for (j = 0; j < nomesColunasCabecalho.length; j++)
				sheet.autoSizeColumn((short) j);

			ByteArrayOutputStream os = new ByteArrayOutputStream();

			wb.write(os);

			return os.toByteArray();

		} finally {

		}

	}

	private static HSSFCellStyle getEstiloCelula(HSSFWorkbook wb) {
		HSSFCellStyle styleCellText = wb.createCellStyle();
		styleCellText.setBorderBottom(HSSFCellStyle.BORDER_THIN);
		styleCellText.setBottomBorderColor(HSSFColor.BLACK.index);
		styleCellText.setBorderLeft(HSSFCellStyle.BORDER_THIN);
		styleCellText.setLeftBorderColor(HSSFColor.BLACK.index);
		styleCellText.setBorderRight(HSSFCellStyle.BORDER_THIN);
		styleCellText.setRightBorderColor(HSSFColor.BLACK.index);
		styleCellText.setBorderTop(HSSFCellStyle.BORDER_THIN);
		styleCellText.setTopBorderColor(HSSFColor.BLACK.index);
		return styleCellText;
	}

	private static HSSFCellStyle getEstiloCabecalho(HSSFWorkbook wb) {
		HSSFCellStyle styleHeader = wb.createCellStyle();
		styleHeader.setFillForegroundColor(HSSFColor.BLACK.index);
		styleHeader.setFillPattern(HSSFCellStyle.SOLID_FOREGROUND);
		styleHeader.setAlignment(HSSFCellStyle.ALIGN_CENTER);

		HSSFFont fontHeader = wb.createFont();
		styleHeader.setFont(fontHeader);
		fontHeader.setColor(HSSFColor.WHITE.index);
		fontHeader.setBoldweight(HSSFFont.BOLDWEIGHT_BOLD);

		return styleHeader;
	}

}
