package br.com.delivery.dtos;

import java.util.ArrayList;
import java.util.List;

import br.com.delivery.models.Menu;

public class MenuDto {

	private List<MenuProductDto> extra;
	private List<MenuProductDto> guarnicao;
	private List<MenuProductDto> prato;
	private List<MenuProductDto> acompanhamneto;
	private List<MenuProductDto> sobremesa;
	private List<MenuProductDto> bebida;
	private List<MenuProductDto> salada;
	private List<MenuProductDto> salgado;
	private List<MenuProductDto> entrada;

	public MenuDto() {
		this.extra = new ArrayList<>();
		this.guarnicao = new ArrayList<>();
		this.prato = new ArrayList<>();
		this.acompanhamneto = new ArrayList<>();
		this.sobremesa = new ArrayList<>();
		this.bebida = new ArrayList<>();
		this.salada = new ArrayList<>();
		this.salgado = new ArrayList<>();
		this.entrada = new ArrayList<>();
	}

	public static MenuDto buildMenu(List<Menu> menus) {
		var dto = new MenuDto();
		menus.forEach(menu -> {
			switch (menu.getType()) {
			case PRATO_PRINCIPAL:
				dto.prato.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case ACOMPANHAMENTOS:
				dto.acompanhamneto.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case BEBIDAS:
				dto.bebida.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case ENTRADAS:
				dto.entrada.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case EXTRAS:
				dto.extra.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case GUARNICAO:
				dto.guarnicao.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case SALADAS:
				dto.salada.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case SALGADOS:
				dto.salgado.add(MenuProductDto.convert(menu.getProduct()));
				break;
			case SOBREMESAS:
				dto.sobremesa.add(MenuProductDto.convert(menu.getProduct()));
				break;
			default:
				break;
			}
		});
		return dto;
	}

	public List<MenuProductDto> getExtra() {
		return extra;
	}

	public void setExtra(List<MenuProductDto> extra) {
		this.extra = extra;
	}

	public List<MenuProductDto> getGuarnicao() {
		return guarnicao;
	}

	public void setGuarnicao(List<MenuProductDto> guarnicao) {
		this.guarnicao = guarnicao;
	}

	public List<MenuProductDto> getPrato() {
		return prato;
	}

	public void setPrato(List<MenuProductDto> prato) {
		this.prato = prato;
	}

	public List<MenuProductDto> getAcompanhamneto() {
		return acompanhamneto;
	}

	public void setAcompanhamneto(List<MenuProductDto> acompanhamneto) {
		this.acompanhamneto = acompanhamneto;
	}

	public List<MenuProductDto> getSobremesa() {
		return sobremesa;
	}

	public void setSobremesa(List<MenuProductDto> sobremesa) {
		this.sobremesa = sobremesa;
	}

	public List<MenuProductDto> getBebida() {
		return bebida;
	}

	public void setBebida(List<MenuProductDto> bebida) {
		this.bebida = bebida;
	}

	public List<MenuProductDto> getSalada() {
		return salada;
	}

	public void setSalada(List<MenuProductDto> salada) {
		this.salada = salada;
	}

	public List<MenuProductDto> getSalgado() {
		return salgado;
	}

	public void setSalgado(List<MenuProductDto> salgado) {
		this.salgado = salgado;
	}

	public List<MenuProductDto> getEntrada() {
		return entrada;
	}

	public void setEntrada(List<MenuProductDto> entrada) {
		this.entrada = entrada;
	}
}
