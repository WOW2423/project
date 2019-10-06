package com.enter.print.pojo.dto.entity;

import com.enter.print.pojo.DoConvertible;
import com.enter.print.pojo.VoConvertible;
import com.enter.print.pojo.entity.PrintService;
import com.enter.print.pojo.vo.PrintServiceVO;
import lombok.Data;
import org.springframework.beans.BeanUtils;

import java.io.Serializable;

/**
 * @author Liquid
 * @version 1.0
 * @date 2019/9/26
 */

@Data
public class PrintServiceDTO implements Serializable {
    private static final long serialVersionUID = 2266261458918463112L;

    /**
     * 服务项目id
     */
    private Integer id;

    /**
     * 关联商家id
     */

    private String merchantId;

    /**
     * 打印服务名称
     */
    private String item;

    /**
     * 打印服务类型（单面/双面）
     */
    private String type;

    /**
     * 打印服务价格
     */
    private String price;



    private static PrintServiceDoConvert printServiceDoConvert;

    private static PrintServiceVoConvert printServiceVoConvert;

    static {
        printServiceDoConvert = new PrintServiceDoConvert();
        printServiceVoConvert = new PrintServiceVoConvert();
    }

    public PrintService convertToDo() {
        return printServiceDoConvert.convertToDO(this);
    }

    public PrintServiceDTO convertToDTO(PrintService printService) {
        return printServiceDoConvert.convertToDTO(printService);
    }


    public PrintServiceVO convertToVo() {
        return printServiceVoConvert.convertToVO(this);
    }

    public PrintServiceDTO convertToDTO(PrintServiceVO printServiceVO) {
        return printServiceVoConvert.convertToDTO(printServiceVO);
    }

    private static class PrintServiceDoConvert implements DoConvertible<PrintService, PrintServiceDTO> {
        @Override
        public PrintService convertToDO(PrintServiceDTO printServiceDTO) {
            PrintService printService = new PrintService();
            BeanUtils.copyProperties(printServiceDTO, printService);
            return printService;
        }

        @Override
        public PrintServiceDTO convertToDTO(PrintService printService) {
            PrintServiceDTO printServiceDTO = new PrintServiceDTO();
            BeanUtils.copyProperties(printService, printServiceDTO);
            return printServiceDTO;
        }
    }

    private static class PrintServiceVoConvert implements VoConvertible<PrintServiceVO, PrintServiceDTO> {

        @Override
        public PrintServiceVO convertToVO(PrintServiceDTO printServiceDTO) {
            PrintServiceVO printServiceVO = new PrintServiceVO();
            BeanUtils.copyProperties(printServiceDTO,printServiceVO );
            return printServiceVO;
        }

        @Override
        public PrintServiceDTO convertToDTO(PrintServiceVO printServiceVO) {
            PrintServiceDTO printServiceDTO = new PrintServiceDTO();
            BeanUtils.copyProperties(printServiceVO, printServiceDTO);
            return printServiceDTO;
        }
    }
}
