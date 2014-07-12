/*
 * To change this template, choose Tools | Templates
 * and open the template in the editor.
 */
package AnalizadorSintactico;

import AnalizadorLexico.Token;
import java.util.ArrayList;

/**
 *
 * @author TV
 */
public class TAS {

    String tabla[][] = new String[183][69];
    Gramatica g[]= new Gramatica[68] ;


    public TAS() {
        for (int i = 0; i < 183; i++) {
            for (int j = 0; j <69; j++) {
                tabla[i][j] = " ";
            }
        }
   tabla[0][1]="!";tabla[0][2]="<<cad>>";tabla[0][3]="<<char>>";tabla[0][4]="(";tabla[0][5]=")";tabla[0][6]="<<opm3>>";	tabla[0][7]="<<opm1>>";	tabla[0][8]=",";tabla[0][9]=".";tabla[0][10]="<<opm2>>";tabla[0][11]="leer";tabla[0][12]="clase";	tabla[0][13]="extiende";tabla[0][14]="implementa";tabla[0][15]="retornar";tabla[0][16]="<<Acceso>>";
tabla[0][17]="defecto";	tabla[0][18]="principal";tabla[0][19]="<<bool>>";tabla[0][20]=":";tabla[0][21]=";";tabla[0][22]="=";	tabla[0][23]="escribir";tabla[0][24]="**";tabla[0][25]="cambio";tabla[0][26]="caso";tabla[0][27]="<<id>>";
tabla[0][28]="lambda";tabla[0][29]="para";tabla[0][30]="hacer";tabla[0][31]="si";tabla[0][32]="sino";
tabla[0][33]="mientras";tabla[0][34]="<<num>>";	tabla[0][35]="<<opbool1>>";tabla[0][36]="<<opbool2>>";tabla[0][37]="sea";	tabla[0][38]="<<Tipodato>>";
tabla[0][39]="nuevo";	tabla[0][40]="{";	tabla[0][41]="}";	tabla[0][42]="$";	tabla[0][43]="<Clase>";	tabla[0][44]="<Herencia>";	tabla[0][45]="<Implementacion>";	tabla[0][46]="<Body>";	tabla[0][47]="<Atributo o Metodo>";	tabla[0][48]="<AUX10>";	tabla[0][49]="<AUX11>";	tabla[0][50]="<Retorno>";	tabla[0][51]="<Cuerpo>";	tabla[0][52]="<Sentencia>";	tabla[0][53]="<AUX9>";	tabla[0][54]="<AUX1>";	tabla[0][55]="<AUX2>";	tabla[0][56]="<AUX3>";	tabla[0][57]="<Operacion>";	tabla[0][58]="<O1>";	tabla[0][59]="<O2>";	tabla[0][60]="<O3>";	tabla[0][61]="<Llamada>";	tabla[0][62]="<AUX5>";	tabla[0][63]="<AUX6>";	tabla[0][64]="<Condicion>";	tabla[0][65]="<AUX8>";	tabla[0][66]="<AUX4>";	tabla[0][67]="<Declaracion>";	tabla[0][68]="<AUX7>";
tabla[1][0]="0";												tabla[1][12]="s1";
tabla[2][0]="1";																											tabla[2][27]="s2";
tabla[3][0]="2";													tabla[3][13]="s4";	tabla[3][14]="r3";																										tabla[3][40]="r3";				tabla[3][44]="3";
tabla[4][0]="3";														tabla[4][14]="s6";																										tabla[4][40]="r5";					tabla[4][45]="5";
tabla[5][0]="4";																											tabla[5][27]="s7";
tabla[6][0]="5";																																								tabla[6][40]="s8";
tabla[7][0]="6";																											tabla[7][27]="s9";
tabla[8][0]="7";														tabla[8][14]="r2";																										tabla[8][40]="r2";
tabla[9][0]="8";																tabla[9][16]="s11";																									tabla[9][41]="r7";					tabla[9][46]="10";
tabla[10][0]="9";								tabla[10][8]="s13";														tabla[10][22]="s14";																		tabla[10][40]="r67";																												tabla[10][68]="12";
tabla[11][0]="10";																																									tabla[11][41]="s15";
tabla[12][0]="11";																		tabla[12][18]="s20";									tabla[12][27]="s19";											tabla[12][38]="s18";			tabla[12][41]="r12";						tabla[12][47]="16";																				tabla[12][67]="17";
tabla[13][0]="12";																																								tabla[13][40]="r4";
tabla[14][0]="13";																											tabla[14][27]="s21";
tabla[15][0]="14";	tabla[15][1]="s28";	tabla[15][2]="s25";	tabla[15][3]="s26";																tabla[15][19]="s29";								tabla[15][27]="s23";							tabla[15][34]="s24";					tabla[15][39]="s27";																tabla[15][55]="22";
tabla[16][0]="15";												tabla[16][12]="s1";																														tabla[16][42]="r1";	tabla[16][43]="30";
tabla[17][0]="16";																																									tabla[17][41]="r6";
tabla[18][0]="17";																					tabla[18][21]="s31";
tabla[19][0]="18";																											tabla[19][27]="s32";
tabla[20][0]="19";				tabla[20][4]="s33";
tabla[21][0]="20";				tabla[21][4]="s34";
tabla[22][0]="21";								tabla[22][8]="s13";													tabla[22][21]="r67";	tabla[22][22]="s14";																		tabla[22][40]="r67";																												tabla[22][68]="35";
tabla[23][0]="22";								tabla[23][8]="s13";													tabla[23][21]="r67";	tabla[23][22]="s14";																		tabla[23][40]="r67";																												tabla[23][68]="36";
tabla[24][0]="23";					tabla[24][5]="r54";		tabla[24][7]="r54";	tabla[24][8]="r54";	tabla[24][9]="s38";	tabla[24][10]="r54";											tabla[24][21]="r54";	tabla[24][22]="r54";		tabla[24][24]="r54";											tabla[24][35]="r54";	tabla[24][36]="r54";				tabla[24][40]="r54";																					tabla[24][61]="37";
tabla[25][0]="24";					tabla[25][5]="r37";		tabla[25][7]="r37";	tabla[25][8]="r37";		tabla[25][10]="r37";											tabla[25][21]="r37";	tabla[25][22]="r37";		tabla[25][24]="r37";											tabla[25][35]="r37";	tabla[25][36]="r37";				tabla[25][40]="r37";
tabla[26][0]="25";					tabla[26][5]="r38";		tabla[26][7]="r38";	tabla[26][8]="r38";		tabla[26][10]="r38";											tabla[26][21]="r38";	tabla[26][22]="r38";		tabla[26][24]="r38";											tabla[26][35]="r38";	tabla[26][36]="r38";				tabla[26][40]="r38";
tabla[27][0]="26";					tabla[27][5]="r39";		tabla[27][7]="r39";	tabla[27][8]="r39";		tabla[27][10]="r39";											tabla[27][21]="r39";	tabla[27][22]="r39";		tabla[27][24]="r39";											tabla[27][35]="r39";	tabla[27][36]="r39";				tabla[27][40]="r39";
tabla[28][0]="27";																											tabla[28][27]="s39";
tabla[29][0]="28";																											tabla[29][27]="s40";
tabla[30][0]="29";					tabla[30][5]="r42";		tabla[30][7]="r42";	tabla[30][8]="r42";		tabla[30][10]="r42";											tabla[30][21]="r42";	tabla[30][22]="r42";		tabla[30][24]="r42";											tabla[30][35]="r42";	tabla[30][36]="r42";				tabla[30][40]="r42";
tabla[31][0]="30";																																										tabla[31][42]="Aceptar";
tabla[32][0]="31";																tabla[32][16]="s11";																									tabla[32][41]="r7";					tabla[32][46]="41";
tabla[33][0]="32";				tabla[33][4]="s42";				tabla[33][8]="s13";													tabla[33][21]="r67";	tabla[33][22]="s14";																																														tabla[33][68]="43";
tabla[34][0]="33";					tabla[34][5]="r14";																																	tabla[34][38]="s45";										tabla[34][48]="44";
tabla[35][0]="34";					tabla[35][5]="s46";
tabla[36][0]="35";																					tabla[36][21]="r65";																			tabla[36][40]="r65";
tabla[37][0]="36";																					tabla[37][21]="r66";																			tabla[37][40]="r66";
tabla[38][0]="37";					tabla[38][5]="r36";		tabla[38][7]="r36";	tabla[38][8]="r36";		tabla[38][10]="r36";											tabla[38][21]="r36";	tabla[38][22]="r36";		tabla[38][24]="r36";											tabla[38][35]="r36";	tabla[38][36]="r36";				tabla[38][40]="r36";
tabla[39][0]="38";																											tabla[39][27]="s47";
tabla[40][0]="39";				tabla[40][4]="s48";
tabla[41][0]="40";					tabla[41][5]="r54";		tabla[41][7]="r54";	tabla[41][8]="r54";	tabla[41][9]="s38";	tabla[41][10]="r54";											tabla[41][21]="r54";	tabla[41][22]="r54";		tabla[41][24]="r54";											tabla[41][35]="r54";	tabla[41][36]="r54";				tabla[41][40]="r54";																					tabla[41][61]="49";
tabla[42][0]="41";																																									tabla[42][41]="r8";
tabla[43][0]="42";					tabla[43][5]="r14";																																	tabla[43][38]="s45";										tabla[43][48]="50";
tabla[44][0]="43";																					tabla[44][21]="r64";
tabla[45][0]="44";					tabla[45][5]="s51";
tabla[46][0]="45";																											tabla[46][27]="s52";
tabla[47][0]="46";																																								tabla[47][40]="s53";
tabla[48][0]="47";				tabla[48][4]="s54";
tabla[49][0]="48";	tabla[49][1]="s28";	tabla[49][2]="s25";	tabla[49][3]="s26";		tabla[49][5]="r56";														tabla[49][19]="s29";								tabla[49][27]="s23";							tabla[49][34]="s24";					tabla[49][39]="s27";																tabla[49][55]="56";							tabla[49][62]="55";
tabla[50][0]="49";					tabla[50][5]="r41";		tabla[50][7]="r41";	tabla[50][8]="r41";		tabla[50][10]="r41";											tabla[50][21]="r41";	tabla[50][22]="r41";		tabla[50][24]="r41";											tabla[50][35]="r41";	tabla[50][36]="r41";				tabla[50][40]="r41";
tabla[51][0]="50";					tabla[51][5]="s57";
tabla[52][0]="51";																																								tabla[52][40]="s58";
tabla[53][0]="52";					tabla[53][5]="r16";			tabla[53][8]="s60";																																									tabla[53][49]="59";
tabla[54][0]="53";											tabla[54][11]="s71";										tabla[54][21]="s73";		tabla[54][23]="s72";				tabla[54][27]="s70";		tabla[54][29]="s68";	tabla[54][30]="s66";	tabla[54][31]="s63";		tabla[54][33]="s64";				tabla[54][37]="s65";	tabla[54][38]="s74";		tabla[54][40]="s67";	tabla[54][41]="r20";										tabla[54][51]="61";	tabla[54][52]="62";															tabla[54][67]="69";
tabla[55][0]="54";	tabla[55][1]="s28";	tabla[55][2]="s25";	tabla[55][3]="s26";		tabla[55][5]="r56";														tabla[55][19]="s29";								tabla[55][27]="s23";							tabla[55][34]="s24";					tabla[55][39]="s27";																tabla[55][55]="56";							tabla[55][62]="75";
tabla[56][0]="55";					tabla[56][5]="s76";
tabla[57][0]="56";					tabla[57][5]="r58";			tabla[57][8]="s78";																																																							tabla[57][63]="77";
tabla[58][0]="57";																																								tabla[58][40]="s79";
tabla[59][0]="58";											tabla[59][11]="s71";										tabla[59][21]="s73";		tabla[59][23]="s72";				tabla[59][27]="s70";		tabla[59][29]="s68";	tabla[59][30]="s66";	tabla[59][31]="s63";		tabla[59][33]="s64";				tabla[59][37]="s65";	tabla[59][38]="s74";		tabla[59][40]="s67";	tabla[59][41]="r20";										tabla[59][51]="80";	tabla[59][52]="62";															tabla[59][67]="69";
tabla[60][0]="59";					tabla[60][5]="r13";
tabla[61][0]="60";					tabla[61][5]="r14";																																	tabla[61][38]="s45";										tabla[61][48]="81";
tabla[62][0]="61";																																									tabla[62][41]="s82";
tabla[63][0]="62";											tabla[63][11]="s71";				tabla[63][15]="r20";						tabla[63][21]="s73";		tabla[63][23]="s72";				tabla[63][27]="s70";		tabla[63][29]="s68";	tabla[63][30]="s66";	tabla[63][31]="s63";		tabla[63][33]="s64";				tabla[63][37]="s65";	tabla[63][38]="s74";		tabla[63][40]="s67";	tabla[63][41]="r20";										tabla[63][51]="83";	tabla[63][52]="62";															tabla[63][67]="69";
tabla[64][0]="63";				tabla[64][4]="s84";
tabla[65][0]="64";				tabla[65][4]="s85";
tabla[66][0]="65";				tabla[66][4]="s86";
tabla[67][0]="66";											tabla[67][11]="s71";										tabla[67][21]="s73";		tabla[67][23]="s72";				tabla[67][27]="s70";		tabla[67][29]="s68";	tabla[67][30]="s66";	tabla[67][31]="s63";		tabla[67][33]="s64";				tabla[67][37]="s65";	tabla[67][38]="s74";		tabla[67][40]="s67";												tabla[67][52]="87";															tabla[67][67]="69";
tabla[68][0]="67";											tabla[68][11]="s71";										tabla[68][21]="s73";		tabla[68][23]="s72";				tabla[68][27]="s70";		tabla[68][29]="s68";	tabla[68][30]="s66";	tabla[68][31]="s63";		tabla[68][33]="s64";				tabla[68][37]="s65";	tabla[68][38]="s74";		tabla[68][40]="s67";	tabla[68][41]="r20";										tabla[68][51]="88";	tabla[68][52]="62";															tabla[68][67]="69";
tabla[69][0]="68";				tabla[69][4]="s89";
tabla[70][0]="69";																					tabla[70][21]="s90";
tabla[71][0]="70";						tabla[71][6]="s93";																tabla[71][22]="s92";																															tabla[71][53]="91";
tabla[72][0]="71";				tabla[72][4]="s94";
tabla[73][0]="72";				tabla[73][4]="s95";
tabla[74][0]="73";											tabla[74][11]="r31";				tabla[74][15]="r31";						tabla[74][21]="r31";		tabla[74][23]="r31";		tabla[74][25]="r31";		tabla[74][27]="r31";		tabla[74][29]="r31";	tabla[74][30]="r31";	tabla[74][31]="r31";	tabla[74][32]="r31";	tabla[74][33]="r31";				tabla[74][37]="r31";	tabla[74][38]="r31";		tabla[74][40]="r31";	tabla[74][41]="r31";
tabla[75][0]="74";																											tabla[75][27]="s96";
tabla[76][0]="75";					tabla[76][5]="s97";
tabla[77][0]="76";					tabla[77][5]="r40";		tabla[77][7]="r40";	tabla[77][8]="r40";		tabla[77][10]="r40";											tabla[77][21]="r40";	tabla[77][22]="r40";		tabla[77][24]="r40";											tabla[77][35]="r40";	tabla[77][36]="r40";				tabla[77][40]="r40";
tabla[78][0]="77";					tabla[78][5]="r55";
tabla[79][0]="78";	tabla[79][1]="s28";	tabla[79][2]="s25";	tabla[79][3]="s26";																tabla[79][19]="s29";								tabla[79][27]="s23";							tabla[79][34]="s24";					tabla[79][39]="s27";																tabla[79][55]="98";
tabla[80][0]="79";											tabla[80][11]="s71";				tabla[80][15]="r20";						tabla[80][21]="s73";		tabla[80][23]="s72";				tabla[80][27]="s70";		tabla[80][29]="s68";	tabla[80][30]="s66";	tabla[80][31]="s63";		tabla[80][33]="s64";				tabla[80][37]="s65";	tabla[80][38]="s74";		tabla[80][40]="s67";	tabla[80][41]="r20";										tabla[80][51]="99";	tabla[80][52]="62";															tabla[80][67]="69";
tabla[81][0]="80";																																									tabla[81][41]="s100";
tabla[82][0]="81";					tabla[82][5]="r15";
tabla[83][0]="82";																tabla[83][16]="s11";																									tabla[83][41]="r7";					tabla[83][46]="101";
tabla[84][0]="83";															tabla[84][15]="r19";																										tabla[84][41]="r19";
tabla[85][0]="84";	tabla[85][1]="s28";	tabla[85][2]="s25";	tabla[85][3]="s26";																tabla[85][19]="s29";								tabla[85][27]="s23";							tabla[85][34]="s24";					tabla[85][39]="s27";																tabla[85][55]="103";									tabla[85][64]="102";
tabla[86][0]="85";	tabla[86][1]="s28";	tabla[86][2]="s25";	tabla[86][3]="s26";																tabla[86][19]="s29";								tabla[86][27]="s23";							tabla[86][34]="s24";					tabla[86][39]="s27";																tabla[86][55]="103";									tabla[86][64]="104";
tabla[87][0]="86";																											tabla[87][27]="s105";
tabla[88][0]="87";																																	tabla[88][33]="s106";
tabla[89][0]="88";																																									tabla[89][41]="s107";
tabla[90][0]="89";																											tabla[90][27]="s108";
tabla[91][0]="90";											tabla[91][11]="r27";				tabla[91][15]="r27";						tabla[91][21]="r27";		tabla[91][23]="r27";		tabla[91][25]="r27";		tabla[91][27]="r27";		tabla[91][29]="r27";	tabla[91][30]="r27";	tabla[91][31]="r27";	tabla[91][32]="r27";	tabla[91][33]="r27";				tabla[91][37]="r27";	tabla[91][38]="r27";		tabla[91][40]="r27";	tabla[91][41]="r27";
tabla[92][0]="91";																					tabla[92][21]="s109";
tabla[93][0]="92";	tabla[93][1]="s28";	tabla[93][2]="s25";	tabla[93][3]="s26";	tabla[93][4]="s115";															tabla[93][19]="s29";								tabla[93][27]="s23";							tabla[93][34]="s24";					tabla[93][39]="s27";																tabla[93][55]="114";		tabla[93][57]="110";	tabla[93][58]="111";	tabla[93][59]="112";	tabla[93][60]="113";
tabla[94][0]="93";	tabla[94][1]="s28";	tabla[94][2]="s25";	tabla[94][3]="s26";																tabla[94][19]="s29";								tabla[94][27]="s23";							tabla[94][34]="s24";					tabla[94][39]="s27";																tabla[94][55]="116";
tabla[95][0]="94";																											tabla[95][27]="s117";
tabla[96][0]="95";	tabla[96][1]="s28";	tabla[96][2]="s25";	tabla[96][3]="s26";	tabla[96][4]="s115";															tabla[96][19]="s29";								tabla[96][27]="s23";							tabla[96][34]="s24";					tabla[96][39]="s27";																tabla[96][55]="114";		tabla[96][57]="118";	tabla[96][58]="111";	tabla[96][59]="112";	tabla[96][60]="113";
tabla[97][0]="96";								tabla[97][8]="s13";													tabla[97][21]="r67";	tabla[97][22]="s14";																																														tabla[97][68]="43";
tabla[98][0]="97";					tabla[98][5]="r53";		tabla[98][7]="r53";	tabla[98][8]="r53";		tabla[98][10]="r53";											tabla[98][21]="r53";	tabla[98][22]="r53";		tabla[98][24]="r53";											tabla[98][35]="r53";	tabla[98][36]="r53";				tabla[98][40]="r53";
tabla[99][0]="98";					tabla[99][5]="r58";			tabla[99][8]="s78";																																																							tabla[99][63]="119";
tabla[100][0]="99";															tabla[100][15]="s121";																										tabla[100][41]="r18";									tabla[100][50]="120";
tabla[101][0]="100";																tabla[101][16]="s11";																									tabla[101][41]="r7";					tabla[101][46]="122";
tabla[102][0]="101";																																									tabla[102][41]="r11";
tabla[103][0]="102";					tabla[103][5]="s123";
tabla[104][0]="103";					tabla[104][5]="r61";																tabla[104][21]="r61";														tabla[104][35]="s125";																														tabla[104][65]="124";
tabla[105][0]="104";					tabla[105][5]="s126";
tabla[106][0]="105";					tabla[106][5]="s127";
tabla[107][0]="106";				tabla[107][4]="s128";
tabla[108][0]="107";											tabla[108][11]="r25";				tabla[108][15]="r25";						tabla[108][21]="r25";		tabla[108][23]="r25";		tabla[108][25]="r25";		tabla[108][27]="r25";		tabla[108][29]="r25";	tabla[108][30]="r25";	tabla[108][31]="r25";	tabla[108][32]="r25";	tabla[108][33]="r25";				tabla[108][37]="r25";	tabla[108][38]="r25";		tabla[108][40]="r25";	tabla[108][41]="r25";
tabla[109][0]="108";																						tabla[109][22]="s129";
tabla[110][0]="109";											tabla[110][11]="r28";				tabla[110][15]="r28";						tabla[110][21]="r28";		tabla[110][23]="r28";		tabla[110][25]="r28";		tabla[110][27]="r28";		tabla[110][29]="r28";	tabla[110][30]="r28";	tabla[110][31]="r28";	tabla[110][32]="r28";	tabla[110][33]="r28";				tabla[110][37]="r28";	tabla[110][38]="r28";		tabla[110][40]="r28";	tabla[110][41]="r28";
tabla[111][0]="110";					tabla[111][5]="r32";		tabla[111][7]="s130";														tabla[111][21]="r32";
tabla[112][0]="111";					tabla[112][5]="r46";		tabla[112][7]="r46";			tabla[112][10]="s131";											tabla[112][21]="r46";
tabla[113][0]="112";					tabla[113][5]="r48";		tabla[113][7]="r48";			tabla[113][10]="r48";											tabla[113][21]="r48";			tabla[113][24]="s132";
tabla[114][0]="113";					tabla[114][5]="r50";		tabla[114][7]="r50";			tabla[114][10]="r50";											tabla[114][21]="r50";			tabla[114][24]="r50";
tabla[115][0]="114";					tabla[115][5]="r51";		tabla[115][7]="r51";			tabla[115][10]="r51";											tabla[115][21]="r51";			tabla[115][24]="r51";
tabla[116][0]="115";	tabla[116][1]="s28";	tabla[116][2]="s25";	tabla[116][3]="s26";	tabla[116][4]="s115";															tabla[116][19]="s29";								tabla[116][27]="s23";							tabla[116][34]="s24";					tabla[116][39]="s27";																tabla[116][55]="114";		tabla[116][57]="133";	tabla[116][58]="111";	tabla[116][59]="112";	tabla[116][60]="113";
tabla[117][0]="116";					tabla[117][5]="r33";																tabla[117][21]="r33";
tabla[118][0]="117";					tabla[118][5]="s134";
tabla[119][0]="118";					tabla[119][5]="s135";		tabla[119][7]="s130";
tabla[120][0]="119";					tabla[120][5]="r57";
tabla[121][0]="120";																																									tabla[121][41]="s136";
tabla[122][0]="121";	tabla[122][1]="s28";	tabla[122][2]="s25";	tabla[122][3]="s26";																tabla[122][19]="s29";								tabla[122][27]="s23";							tabla[122][34]="s24";					tabla[122][39]="s27";																tabla[122][55]="137";
tabla[123][0]="122";																																									tabla[123][41]="r10";
tabla[124][0]="123";											tabla[124][11]="s71";										tabla[124][21]="s73";		tabla[124][23]="s72";				tabla[124][27]="s70";		tabla[124][29]="s68";	tabla[124][30]="s66";	tabla[124][31]="s63";		tabla[124][33]="s64";				tabla[124][37]="s65";	tabla[124][38]="s74";		tabla[124][40]="s67";												tabla[124][52]="138";															tabla[124][67]="69";
tabla[125][0]="124";					tabla[125][5]="r59";																tabla[125][21]="r59";
tabla[126][0]="125";	tabla[126][1]="s28";	tabla[126][2]="s25";	tabla[126][3]="s26";																tabla[126][19]="s29";								tabla[126][27]="s23";							tabla[126][34]="s24";					tabla[126][39]="s27";																tabla[126][55]="139";
tabla[127][0]="126";											tabla[127][11]="s71";										tabla[127][21]="s73";		tabla[127][23]="s72";				tabla[127][27]="s70";		tabla[127][29]="s68";	tabla[127][30]="s66";	tabla[127][31]="s63";		tabla[127][33]="s64";				tabla[127][37]="s65";	tabla[127][38]="s74";		tabla[127][40]="s67";												tabla[127][52]="140";															tabla[127][67]="69";
tabla[128][0]="127";																																								tabla[128][40]="s141";
tabla[129][0]="128";	tabla[129][1]="s28";	tabla[129][2]="s25";	tabla[129][3]="s26";																tabla[129][19]="s29";								tabla[129][27]="s23";							tabla[129][34]="s24";					tabla[129][39]="s27";																tabla[129][55]="103";									tabla[129][64]="142";
tabla[130][0]="129";	tabla[130][1]="s28";	tabla[130][2]="s25";	tabla[130][3]="s26";																tabla[130][19]="s29";								tabla[130][27]="s23";							tabla[130][34]="s24";					tabla[130][39]="s27";																tabla[130][55]="143";
tabla[131][0]="130";	tabla[131][1]="s28";	tabla[131][2]="s25";	tabla[131][3]="s26";	tabla[131][4]="s115";															tabla[131][19]="s29";								tabla[131][27]="s23";							tabla[131][34]="s24";					tabla[131][39]="s27";																tabla[131][55]="114";			tabla[131][58]="144";	tabla[131][59]="112";	tabla[131][60]="113";
tabla[132][0]="131";	tabla[132][1]="s28";	tabla[132][2]="s25";	tabla[132][3]="s26";	tabla[132][4]="s115";															tabla[132][19]="s29";								tabla[132][27]="s23";							tabla[132][34]="s24";					tabla[132][39]="s27";																tabla[132][55]="114";				tabla[132][59]="145";	tabla[132][60]="113";
tabla[133][0]="132";	tabla[133][1]="s28";	tabla[133][2]="s25";	tabla[133][3]="s26";	tabla[133][4]="s115";															tabla[133][19]="s29";								tabla[133][27]="s23";							tabla[133][34]="s24";					tabla[133][39]="s27";																tabla[133][55]="114";					tabla[133][60]="146";
tabla[134][0]="133";					tabla[134][5]="s147";		tabla[134][7]="s130";
tabla[135][0]="134";																					tabla[135][21]="s148";
tabla[136][0]="135";																					tabla[136][21]="s149";
tabla[137][0]="136";																tabla[137][16]="s11";																									tabla[137][41]="r7";					tabla[137][46]="150";
tabla[138][0]="137";																					tabla[138][21]="s151";
tabla[139][0]="138";											tabla[139][11]="r35";				tabla[139][15]="r35";						tabla[139][21]="r35";		tabla[139][23]="r35";		tabla[139][25]="r35";		tabla[139][27]="r35";		tabla[139][29]="r35";	tabla[139][30]="r35";	tabla[139][31]="r35";	tabla[139][32]="s153";	tabla[139][33]="r35";				tabla[139][37]="r35";	tabla[139][38]="r35";		tabla[139][40]="r35";	tabla[139][41]="r35";													tabla[139][54]="152";
tabla[140][0]="139";					tabla[140][5]="r63";																tabla[140][21]="r63";															tabla[140][36]="s155";																														tabla[140][66]="154";
tabla[141][0]="140";											tabla[141][11]="r22";				tabla[141][15]="r22";						tabla[141][21]="r22";		tabla[141][23]="r22";		tabla[141][25]="r22";		tabla[141][27]="r22";		tabla[141][29]="r22";	tabla[141][30]="r22";	tabla[141][31]="r22";	tabla[141][32]="r22";	tabla[141][33]="r22";				tabla[141][37]="r22";	tabla[141][38]="r22";		tabla[141][40]="r22";	tabla[141][41]="r22";
tabla[142][0]="141";																	tabla[142][17]="s158";									tabla[142][26]="s157";																														tabla[142][56]="156";
tabla[143][0]="142";					tabla[143][5]="s159";
tabla[144][0]="143";																					tabla[144][21]="s160";
tabla[145][0]="144";					tabla[145][5]="r45";		tabla[145][7]="r45";			tabla[145][10]="s131";											tabla[145][21]="r45";
tabla[146][0]="145";					tabla[146][5]="r47";		tabla[146][7]="r47";			tabla[146][10]="r47";											tabla[146][21]="r47";			tabla[146][24]="s132";
tabla[147][0]="146";					tabla[147][5]="r49";		tabla[147][7]="r49";			tabla[147][10]="r49";											tabla[147][21]="r49";			tabla[147][24]="r49";
tabla[148][0]="147";					tabla[148][5]="r52";		tabla[148][7]="r52";			tabla[148][10]="r52";											tabla[148][21]="r52";			tabla[148][24]="r52";
tabla[149][0]="148";											tabla[149][11]="r29";										tabla[149][21]="r29";		tabla[149][23]="r29";		tabla[149][25]="r29";		tabla[149][27]="r29";		tabla[149][29]="r29";	tabla[149][30]="r29";	tabla[149][31]="r29";	tabla[149][32]="r29";	tabla[149][33]="r29";				tabla[149][37]="r29";	tabla[149][38]="r29";		tabla[149][40]="r29";	tabla[149][41]="r29";
tabla[150][0]="149";											tabla[150][11]="r30";				tabla[150][15]="r29";						tabla[150][21]="r30";		tabla[150][23]="r30";		tabla[150][25]="r30";		tabla[150][27]="r30";		tabla[150][29]="r30";	tabla[150][30]="r30";	tabla[150][31]="r30";	tabla[150][32]="r30";	tabla[150][33]="r30";				tabla[150][37]="r30";	tabla[150][38]="r30";		tabla[150][40]="r30";	tabla[150][41]="r30";
tabla[151][0]="150";															tabla[151][15]="r30";																										tabla[151][41]="r9";
tabla[152][0]="151";																																									tabla[152][41]="r17";
tabla[153][0]="152";											tabla[153][11]="r21";				tabla[153][15]="r21";						tabla[153][21]="r21";		tabla[153][23]="r21";		tabla[153][25]="r21";		tabla[153][27]="r21";		tabla[153][29]="r21";	tabla[153][30]="r21";	tabla[153][31]="r21";	tabla[153][32]="r21";	tabla[153][33]="r21";				tabla[153][37]="r21";	tabla[153][38]="r21";		tabla[153][40]="r21";	tabla[153][41]="r21";
tabla[154][0]="153";											tabla[154][11]="s71";										tabla[154][21]="s73";		tabla[154][23]="s72";				tabla[154][27]="s70";		tabla[154][29]="s68";	tabla[154][30]="s66";	tabla[154][31]="s63";		tabla[154][33]="s64";				tabla[154][37]="s65";	tabla[154][38]="s74";		tabla[154][40]="s67";												tabla[154][52]="161";															tabla[154][67]="69";
tabla[155][0]="154";					tabla[155][5]="r60";																tabla[155][21]="r60";
tabla[156][0]="155";	tabla[156][1]="s28";	tabla[156][2]="s25";	tabla[156][3]="s26";																tabla[156][19]="s29";								tabla[156][27]="s23";							tabla[156][34]="s24";					tabla[156][39]="s27";																tabla[156][55]="103";									tabla[156][64]="162";
tabla[157][0]="156";																																									tabla[157][41]="s163";
tabla[158][0]="157";																																		tabla[158][34]="s164";
tabla[159][0]="158";																				tabla[159][20]="s165";
tabla[160][0]="159";																					tabla[160][21]="s166";
tabla[161][0]="160";	tabla[161][1]="s28";	tabla[161][2]="s25";	tabla[161][3]="s26";																tabla[161][19]="s29";								tabla[161][27]="s23";							tabla[161][34]="s24";					tabla[161][39]="s27";																tabla[161][55]="103";									tabla[161][64]="167";
tabla[162][0]="161";											tabla[162][11]="r34";				tabla[162][15]="r34";						tabla[162][21]="r34";		tabla[162][23]="r34";		tabla[162][25]="r34";		tabla[162][27]="r34";		tabla[162][29]="r34";	tabla[162][30]="r34";	tabla[162][31]="r34";	tabla[162][32]="r34";	tabla[162][33]="r34";				tabla[162][37]="r34";	tabla[162][38]="r34";		tabla[162][40]="r34";	tabla[162][41]="r34";
tabla[163][0]="162";					tabla[163][5]="r62";																tabla[163][21]="r62";
tabla[164][0]="163";											tabla[164][11]="s71";										tabla[164][21]="s73";		tabla[164][23]="s72";				tabla[164][27]="s70";		tabla[164][29]="s68";	tabla[164][30]="s66";	tabla[164][31]="s63";		tabla[164][33]="s64";				tabla[164][37]="s65";	tabla[164][38]="s74";		tabla[164][40]="s67";												tabla[164][52]="168";															tabla[164][67]="69";
tabla[165][0]="164";																				tabla[165][20]="s169";
tabla[166][0]="165";											tabla[166][11]="s71";										tabla[166][21]="s73";		tabla[166][23]="s72";				tabla[166][27]="s70";		tabla[166][29]="s68";	tabla[166][30]="s66";	tabla[166][31]="s63";		tabla[166][33]="s64";				tabla[166][37]="s65";	tabla[166][38]="s74";		tabla[166][40]="s67";												tabla[166][52]="170";															tabla[166][67]="69";
tabla[167][0]="166";											tabla[167][11]="r24";				tabla[167][15]="r24";						tabla[167][21]="r24";		tabla[167][23]="r24";		tabla[167][25]="r24";		tabla[167][27]="r24";		tabla[167][29]="r24";	tabla[167][30]="r24";	tabla[167][31]="r24";	tabla[167][32]="r24";	tabla[167][33]="r24";				tabla[167][37]="r24";	tabla[167][38]="r24";		tabla[167][40]="r24";	tabla[167][41]="r24";
tabla[168][0]="167";																					tabla[168][21]="s171";
tabla[169][0]="168";											tabla[169][11]="r23";				tabla[169][15]="r23";						tabla[169][21]="r23";		tabla[169][23]="r23";		tabla[169][25]="r23";		tabla[169][27]="r23";		tabla[169][29]="r23";	tabla[169][30]="r23";	tabla[169][31]="r23";	tabla[169][32]="r23";	tabla[169][33]="r23";				tabla[169][37]="r23";	tabla[169][38]="r23";		tabla[169][40]="r23";	tabla[169][41]="r23";
tabla[170][0]="169";											tabla[170][11]="s71";										tabla[170][21]="s73";		tabla[170][23]="s72";				tabla[170][27]="s70";		tabla[170][29]="s68";	tabla[170][30]="s66";	tabla[170][31]="s63";		tabla[170][33]="s64";				tabla[170][37]="s65";	tabla[170][38]="s74";		tabla[170][40]="s67";												tabla[170][52]="172";															tabla[170][67]="69";
tabla[171][0]="170";																									tabla[171][25]="s173";
tabla[172][0]="171";																											tabla[172][27]="s174";
tabla[173][0]="172";																									tabla[173][25]="s175";
tabla[174][0]="173";																					tabla[174][21]="s176";
tabla[175][0]="174";						tabla[175][6]="s93";																tabla[175][22]="s92";																															tabla[175][53]="177";
tabla[176][0]="175";																					tabla[176][21]="s178";
tabla[177][0]="176";																																									tabla[177][41]="r44";
tabla[178][0]="177";					tabla[178][5]="s179";
tabla[179][0]="178";																	tabla[179][17]="s168";									tabla[179][26]="s157";																														tabla[179][56]="180";
tabla[180][0]="179";											tabla[180][11]="s71";										tabla[180][21]="s73";		tabla[180][23]="s72";				tabla[180][27]="s70";		tabla[180][29]="s68";	tabla[180][30]="s66";	tabla[180][31]="s63";		tabla[180][33]="s64";				tabla[180][37]="s65";	tabla[180][38]="s74";		tabla[180][40]="s67";												tabla[180][52]="181";															tabla[180][67]="69";
tabla[181][0]="180";																																									tabla[181][41]="r43";
tabla[182][0]="181";											tabla[182][11]="r26";				tabla[182][15]="r26";						tabla[182][21]="r26";		tabla[182][23]="r26";		tabla[182][25]="r26";		tabla[182][27]="r26";		tabla[182][29]="r26";	tabla[182][30]="r26";	tabla[182][31]="r26";	tabla[182][32]="r26";	tabla[182][33]="r26";				tabla[182][37]="r26";	tabla[182][38]="r26";		tabla[182][40]="r26";	tabla[182][41]="r26";

   for (int j = 0; j < 68; j++)
                g[j] = new Gramatica();

g[0].t.add("<Clase>");			g[0].t.add("clase");	g[0].t.add("<<id>>");		g[0].t.add("<Herencia>");	g[0].t.add("<Implementacion>");	g[0].t.add("{");	g[0].t.add("<Body>");		g[0].t.add("}");	g[0].t.add("<Clase>");
g[1].t.add("<Clase>");
g[2].t.add("<Herencia>");			g[2].t.add("extiende");	g[2].t.add(" <<id>>");
g[3].t.add("<Herencia>");			
g[4].t.add("<Implementacion>");		g[4].t.add("implementa");	g[4].t.add("<<id>>");		g[4].t.add("<AUX7> ");
g[5].t.add("<Implementacion>");
g[6].t.add("<Body>");				g[6].t.add("<<Acceso>>");	g[6].t.add("<Atributo o Metodo>");
g[7].t.add("<Body>");
g[8].t.add("<Atributo o Metodo>");		g[8].t.add("<Declaracion>");		g[8].t.add(";");	g[8].t.add("<Body> ");
g[9].t.add("<Atributo o Metodo>");		g[9].t.add("<<Tipodato>>");	g[9].t.add("<<id>>");	g[9].t.add("(");	g[9].t.add("<AUX10>");	g[9].t.add(")");	g[9].t.add("{");	g[9].t.add("<Cuerpo>");	g[9].t.add("<Retorno>");	g[9].t.add("}");	g[9].t.add("<Body>");
g[10].t.add("<Atributo o Metodo>");		g[10].t.add("<<id>>");	g[10].t.add("(");	g[10].t.add("<AUX10>");	g[10].t.add(")");	g[10].t.add("{");	g[10].t.add("<Cuerpo>");	g[10].t.add("}");	g[10].t.add("<Body>");
g[11].t.add("<Atributo o Metodo>");		g[11].t.add("principal");	g[11].t.add("(");	g[11].t.add(")");	g[11].t.add("{");	g[11].t.add("<Cuerpo>");	g[11].t.add("}");	g[11].t.add("<Body>");
g[12].t.add("<Atributo o Metodo>");		g[12].t.add("e");
g[13].t.add("<AUX10>");			g[13].t.add("<<Tipodato>>");		g[13].t.add("<<id>>");		g[13].t.add("<AUX11>  ");
g[14].t.add("<AUX10>");
g[15].t.add("<AUX11>");			g[15].t.add(",");	g[15].t.add("<AUX10> ");
g[16].t.add("<AUX11>");
g[17].t.add("<Retorno>");		g[17].t.add("retornar");	g[17].t.add("<AUX2>");	g[17].t.add("; ");
g[18].t.add("<Retorno>");
g[19].t.add("<Cuerpo>");		g[19].t.add("<Sentencia>");	g[19].t.add("<Cuerpo> ");
g[20].t.add("<Cuerpo>");
g[21].t.add("<Sentencia>");		g[21].t.add("si");	g[21].t.add("(");	g[21].t.add("<Condicion>");	g[21].t.add(")");	g[21].t.add("<Sentencia>");	g[21].t.add("<AUX1> ");
g[22].t.add("<Sentencia>");		g[22].t.add("mientras");	g[22].t.add("(");	g[22].t.add("<Condicion>");	g[22].t.add(")");	g[22].t.add("<Sentencia> ");
g[23].t.add("<Sentencia>");		g[23].t.add("sea");	g[23].t.add("(");	g[23].t.add("<<id>>");	g[23].t.add(")");	g[23].t.add("{");	g[23].t.add("<AUX3>");	g[23].t.add("}");	g[23].t.add("<Sentencia> ");
g[24].t.add("<Sentencia>");		g[24].t.add("hacer");	g[24].t.add("<Sentencia>");	g[24].t.add("mientras");	g[24].t.add("(");	g[24].t.add("<Condicion>");	g[24].t.add(")");	g[24].t.add("; ");
g[25].t.add("<Sentencia>");		g[25].t.add("{");	g[25].t.add("<Cuerpo>");	g[25].t.add("} ");
g[26].t.add("<Sentencia>");		g[26].t.add("para");	g[26].t.add("(");	g[26].t.add("<<id>>");	g[26].t.add("=");	g[26].t.add("<AUX2>");	g[26].t.add(";");	g[26].t.add("<Condicion>");	g[26].t.add(";");	g[26].t.add("<<id>>");	g[26].t.add("<AUX9>");	g[26].t.add(")");	g[26].t.add("<Sentencia>");
g[27].t.add("<Sentencia>");		g[27].t.add("<Declaracion>");	g[27].t.add("; ");
g[28].t.add("<Sentencia>");		g[28].t.add("<<id>>");	g[28].t.add("<AUX9>");	g[28].t.add(";");
g[29].t.add("<Sentencia>");		g[29].t.add("leer");	g[29].t.add("(");	g[29].t.add("<<id>>");	g[29].t.add(")");	g[29].t.add("; ");
g[30].t.add("<Sentencia>");		g[30].t.add("escribir");	g[30].t.add("(");	g[30].t.add("<Operacion>");	g[30].t.add(")");	g[30].t.add("; ");
g[31].t.add("<Sentencia>");		g[31].t.add(";");
g[32].t.add("<AUX9>");		g[32].t.add("=");	g[32].t.add("<Operacion> ");
g[33].t.add("<AUX9>");		g[33].t.add("*");	g[33].t.add("<AUX2> ");
g[34].t.add("<AUX1>");		g[34].t.add("sino");	g[34].t.add("<Sentencia> ");
g[35].t.add("<AUX1>");
g[36].t.add("<AUX2>");		g[36].t.add("<<id>>");		g[36].t.add("<Llamada>");
g[37].t.add("<AUX2>");		g[37].t.add("<<num>>");
g[38].t.add("<AUX2>");		g[38].t.add("<<cad>>");
g[39].t.add("<AUX2>");		g[39].t.add("<<char>> ");
g[40].t.add("<AUX2>");		g[40].t.add("nuevo");		g[40].t.add("<<id>>");		g[40].t.add("(");	g[40].t.add("<AUX5>");	g[40].t.add(") ");
g[41].t.add("<AUX2>");		g[41].t.add("!");	g[41].t.add("<<id>>");		g[41].t.add("<Llamada> ");
g[42].t.add("<AUX2>");		g[42].t.add("bool");
g[43].t.add("<AUX3>");		g[43].t.add("caso");	g[43].t.add("<<num>>");	g[43].t.add(":");	g[43].t.add("<Sentencia>");	g[43].t.add("cambio");	g[43].t.add(";");	g[43].t.add("<AUX3>");
g[44].t.add("<AUX3>");		g[44].t.add("defecto");		g[44].t.add(":");	g[44].t.add("<Sentencia>");	g[44].t.add("cambio");	g[44].t.add("; ");
g[45].t.add("<Operacion>");		g[45].t.add("<Operacion>");	g[45].t.add("+");	g[45].t.add("<O1> ");
g[46].t.add("<Operacion>");		g[46].t.add("<O1> ");
g[47].t.add("<O1>");			g[47].t.add("<O1>");	g[47].t.add("/");	g[47].t.add("<O2>");
g[48].t.add("<O1>");			g[48].t.add("<O2> ");
g[49].t.add("<O2>");			g[49].t.add("<O2>");	g[49].t.add("@");	g[49].t.add("<O3>");
g[50].t.add("<O2>");			g[50].t.add("<O3>");
g[51].t.add("<O3>");			g[51].t.add("<AUX2> ");
g[52].t.add("<O3>");			g[52].t.add("(");	g[52].t.add("<Operacion>");	g[52].t.add(")");
g[53].t.add("<Llamada>");		g[53].t.add(".");	g[53].t.add("<<Id>>");		g[53].t.add("(");	g[53].t.add("<AUX5>");	g[53].t.add(") ");
g[54].t.add("<Llamada>");		
g[55].t.add("<AUX5>");		g[55].t.add("<AUX2>");	g[55].t.add("<AUX6>");
g[56].t.add("<AUX5>");
g[57].t.add("<AUX6>");		g[57].t.add(",");	g[57].t.add("<AUX2>");	g[57].t.add("<AUX6>");
g[58].t.add("<AUX6>");
g[59].t.add("<Condicion>");		g[59].t.add("<AUX2>");	g[59].t.add("<AUX8> ");
g[60].t.add("<AUX8>");		g[60].t.add("<<opbool1>>");	g[60].t.add("<AUX2>");	g[60].t.add("<AUX4>");
g[61].t.add("<AUX8>");
g[62].t.add("<AUX4>");		g[62].t.add("<<opbool2>>");	g[62].t.add("<Condicion>");
g[63].t.add("<AUX4>");
g[64].t.add("<Declaracion>");		g[64].t.add("<<Tipodato>>");	g[64].t.add("<<id>>");	g[64].t.add("<AUX7> ");
g[65].t.add("<AUX7>");		g[65].t.add(",");	g[65].t.add("<<id>>");	g[65].t.add("<AUX7>");
g[66].t.add("<AUX7>");		g[66].t.add("=");	g[66].t.add("<AUX2>");	g[66].t.add("<AUX7> ");
g[67].t.add("<AUX7>");		


       

    }

    public String interseccion(int estado, String simb){
       int ind= 0;
       for (int j = 1; j < 69 ; j++){
            if(tabla[0][j].equals(simb)) ind = j;
       }

    return tabla[estado+1][ind];
    }

    public String esID(String a){
         boolean encontrado = false;
         for(int i=1; i<69;i++){
              if(a.equals(tabla[0][i]))encontrado = true;
         }
         if(encontrado == true)  return a;
         else return "i";
    }

    public String Simbolo(Token t){
    String s=t.getNombre();
    boolean encontrado = false;
         for(int i=1; i<69;i++){
              if(s.equals(tabla[0][i]))encontrado = true;
         }
         if(encontrado == true)  return s;

    else if(s.equals("publico")||s.equals("privado"))
      s="<<Acceso>>";
    else if(s.equals("+")||s.equals("-"))
      s="<<opm1>>";
    else if(s.equals("*")||s.equals("%")||s.equals("/"))
      s="<<opm2>>";
    else if(s.equals("+=")||s.equals("-=")||s.equals("*=")||s.equals("/="))
      s="<<opm3>>";
    else if(s.equals("<")||s.equals(">")||s.equals("!=")||s.equals("<=")||s.equals(">=")||s.equals("=="))
      s="<<opbool1>>";
    else if(s.equals("^")||s.equals("&&")||s.equals("||"))
      s="<<opbool2>>";
    else if(s.equals("bool")||s.equals("entero")||s.equals("real")||s.equals("caracter")||s.equals("cadena"))
      s="<<Tipodato>>";
     else if(s.equals("verdadero")||s.equals("falso"))
      s="<<bool>>";
    else if(t.getNumero()==500)
      s="<<num>>";
    else if(t.getNumero()==600)
      s="<<id>>";
    else if(t.getNumero()==700)
      s="<<char>>";
    else if(t.getNumero()==800)
      s="<<cad>>";
    else return s;
    return s;
    }

    public String analizar(ArrayList<String> pila, ArrayList<String> cadena){
        String aux = "";
        int numsimb = 0;
        boolean error = false;
        String intersec = "";                  
   
            intersec = interseccion(Integer.parseInt(pila.get(pila.size()-1)),esID(cadena.get(0)));
            System.out.println(intersec);
            for(int i = 0; i< pila.size(); i++){
                                aux = aux + (pila.get(i)+" ");
                            }
                            aux = aux +("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                               aux = aux +(cadena.get(i)+" ");
                            }
            while(!intersec.equals("Aceptar") && error == false){
                    try{
                        if(intersec.charAt(0) == 'r'){
                       
                       
                            String numaux = "";
                            for(int i = 1; i<intersec.length();i++){
                                 numaux = numaux + intersec.charAt(i);
                            }
                            
                            numsimb = g[Integer.parseInt(numaux)].t.size()-1;
                            
                            System.out.println(numsimb+" "+numaux+"r");
                            for(int i=1;i<=2*numsimb;i++){
                                pila.remove(pila.size()-1); 
                            }
                            
                            pila.add(g[Integer.parseInt(numaux)].t.get(0)); 
                            pila.add(interseccion(Integer.parseInt(pila.get(pila.size()-2)),esID(pila.get(pila.size()-1))));
                            aux = aux +("reducir "+intersec+"\n");
                      
                            for(int i = 0; i< pila.size(); i++){
                                aux = aux+(pila.get(i)+" ");
                            }
                            aux = aux + ("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                                aux = aux+(cadena.get(i)+" ");
                            }
                         
                        }else if(intersec.charAt(0) == 's'){
                            String numaux = "";
                            pila.add(cadena.get(0));
                            for(int i = 1; i<intersec.length();i++){
                                 numaux = numaux + intersec.charAt(i);
                            }
                            pila.add(numaux);

                            System.out.println(numaux+"s");
                            cadena.remove(0);
                             aux = aux + ("desplazar "+intersec+"\n");  
                             
                              for(int i = 0; i< pila.size(); i++){
                                aux = aux+(pila.get(i)+" ");
                            }
                            aux = aux +("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                                aux = aux +(cadena.get(i)+" ");
                            }
                       
                        }else if(Integer.parseInt(intersec)>=0){
                               error = true;
                               
                             
                        }else if(intersec.equals(" ")){
                                 error = true;
                                 
                                 
                        }
                  
                        intersec = interseccion(Integer.parseInt(pila.get(pila.size()-1)),esID(cadena.get(0)));

                   }catch(Exception e){
                            error = true;
                                              
                  }
                 
            }
           if(intersec.equals("Aceptar"))aux = aux + ("Sintaxis correcta \n");
           else aux = aux + ("error \n");
    return aux;
    }

     public String analizar1(ArrayList<String> pila, ArrayList<Token> cadena){
        String aux = "";
        int numsimb = 0;
        boolean error = false;
        String intersec = "";

            intersec = interseccion(Integer.parseInt(pila.get(pila.size()-1)),Simbolo(cadena.get(0)));
            System.out.println(intersec);
            for(int i = 0; i< pila.size(); i++){
                                aux = aux + (pila.get(i)+" ");
                            }
                            aux = aux +("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                               aux = aux +(cadena.get(i).getNombre()+" ");
                            }
            while(!intersec.equals("Aceptar") && error == false){
                    try{
                        if(intersec.charAt(0) == 'r'){


                            String numaux = "";
                            for(int i = 1; i<intersec.length();i++){
                                 numaux = numaux + intersec.charAt(i);
                            }

                            numsimb = g[Integer.parseInt(numaux)].t.size()-1;
                            System.out.println(numsimb+" "+numaux+"r");

                            for(int i=1;i<=2*numsimb;i++){
                                pila.remove(pila.size()-1);
                            }

                            pila.add(g[Integer.parseInt(numaux)].t.get(0));
                            pila.add(interseccion(Integer.parseInt(pila.get(pila.size()-2)),Simbolo(new Token(pila.get(pila.size()-1),0))));
                            aux = aux +("reducir "+intersec+"\n");

                            for(int i = 0; i< pila.size(); i++){
                                aux = aux+(pila.get(i)+" ");
                            }
                            aux = aux + ("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                                aux = aux+(cadena.get(i).getNombre()+" ");
                            }

                        }else if(intersec.charAt(0) == 's'){
                            String numaux = "";
                            pila.add(cadena.get(0).getNombre());
                            for(int i = 1; i<intersec.length();i++){
                                 numaux = numaux + intersec.charAt(i);
                            }
                            System.out.println(numaux+"s");
                            pila.add(numaux);

                            cadena.remove(0);
                             aux = aux + ("desplazar "+intersec+"\n");

                              for(int i = 0; i< pila.size(); i++){
                                aux = aux+(pila.get(i)+" ");
                            }
                            aux = aux +("   ------   ");
                            for(int i = 0; i< cadena.size(); i++){
                                aux = aux +(cadena.get(i).getNombre()+" ");
                            }

                        }else if(Integer.parseInt(intersec)>=0){
                               error = true;


                        }else if(intersec.equals(" ")){
                                 error = true;


                        }

                        intersec = interseccion(Integer.parseInt(pila.get(pila.size()-1)),Simbolo(cadena.get(0)));

                   }catch(Exception e){
                            error = true;

                  }

            }
           if(intersec.equals("Aceptar"))aux = aux + ("Sintaxis correcta \n");
           else aux = aux + ("error \n");
    return aux;
    }


}
