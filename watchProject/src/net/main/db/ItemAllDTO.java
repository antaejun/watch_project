package net.main.db;

import net.code.db.CodeDTO;
import net.items.db.CodeDetailDTO;
import net.items.db.ItemDTO;

public class ItemAllDTO {
	private ItemDTO itemDTO;
	private ImageTableDTO imageDTO;
	private CodeDTO codeDTO;
	private CodeDetailDTO codeDetailDTO;
	
	
	
	public ItemDTO getItemDTO() {
		return itemDTO;
	}
	public void setItemDTO(ItemDTO itemDTO) {
		this.itemDTO = itemDTO;
	}
	public ImageTableDTO getImageDTO() {
		return imageDTO;
	}
	public void setImageDTO(ImageTableDTO imageDTO) {
		this.imageDTO = imageDTO;
	}
	public CodeDTO getCodeDTO() {
		return codeDTO;
	}
	public void setCodeDTO(CodeDTO codeDTO) {
		this.codeDTO = codeDTO;
	}
	public CodeDetailDTO getCodeDetailDTO() {
		return codeDetailDTO;
	}
	public void setCodeDetailDTO(CodeDetailDTO codeDetailDTO) {
		this.codeDetailDTO = codeDetailDTO;
	}

}
