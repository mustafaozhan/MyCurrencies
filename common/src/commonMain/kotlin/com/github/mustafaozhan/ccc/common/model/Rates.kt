/*
 * Copyright (c) 2020 Mustafa Ozhan. All rights reserved.
 */
package com.github.mustafaozhan.ccc.common.model

import com.github.mustafaozhan.ccc.common.Offline_rates

data class Rates(
    var base: String = "",
    var date: String? = null,
    var aED: Double? = null,
    var aFN: Double? = null,
    var aLL: Double? = null,
    var aMD: Double? = null,
    var aNG: Double? = null,
    var aOA: Double? = null,
    var aRS: Double? = null,
    var aUD: Double? = null,
    var aWG: Double? = null,
    var aZN: Double? = null,
    var bAM: Double? = null,
    var bBD: Double? = null,
    var bDT: Double? = null,
    var bGN: Double? = null,
    var bHD: Double? = null,
    var bIF: Double? = null,
    var bMD: Double? = null,
    var bND: Double? = null,
    var bOB: Double? = null,
    var bRL: Double? = null,
    var bSD: Double? = null,
    var bTC: Double? = null,
    var bTN: Double? = null,
    var bWP: Double? = null,
    var bYN: Double? = null,
    var bYR: Double? = null,
    var bZD: Double? = null,
    var cAD: Double? = null,
    var cDF: Double? = null,
    var cHF: Double? = null,
    var cLF: Double? = null,
    var cLP: Double? = null,
    var cNY: Double? = null,
    var cOP: Double? = null,
    var cRC: Double? = null,
    var cUC: Double? = null,
    var cUP: Double? = null,
    var cVE: Double? = null,
    var cZK: Double? = null,
    var dJF: Double? = null,
    var dKK: Double? = null,
    var dOP: Double? = null,
    var dZD: Double? = null,
    var eGP: Double? = null,
    var eRN: Double? = null,
    var eTB: Double? = null,
    var eUR: Double? = null,
    var fJD: Double? = null,
    var fKP: Double? = null,
    var gBP: Double? = null,
    var gEL: Double? = null,
    var gGP: Double? = null,
    var gHS: Double? = null,
    var gIP: Double? = null,
    var gMD: Double? = null,
    var gNF: Double? = null,
    var gTQ: Double? = null,
    var gYD: Double? = null,
    var hKD: Double? = null,
    var hNL: Double? = null,
    var hRK: Double? = null,
    var hTG: Double? = null,
    var hUF: Double? = null,
    var iDR: Double? = null,
    var iLS: Double? = null,
    var iMP: Double? = null,
    var iNR: Double? = null,
    var iQD: Double? = null,
    var iRR: Double? = null,
    var iSK: Double? = null,
    var jEP: Double? = null,
    var jMD: Double? = null,
    var jOD: Double? = null,
    var jPY: Double? = null,
    var kES: Double? = null,
    var kGS: Double? = null,
    var kHR: Double? = null,
    var kMF: Double? = null,
    var kPW: Double? = null,
    var kRW: Double? = null,
    var kWD: Double? = null,
    var kYD: Double? = null,
    var kZT: Double? = null,
    var lAK: Double? = null,
    var lBP: Double? = null,
    var lKR: Double? = null,
    var lRD: Double? = null,
    var lSL: Double? = null,
    var lTL: Double? = null,
    var lVL: Double? = null,
    var lYD: Double? = null,
    var mAD: Double? = null,
    var mDL: Double? = null,
    var mGA: Double? = null,
    var mKD: Double? = null,
    var mMK: Double? = null,
    var mNT: Double? = null,
    var mOP: Double? = null,
    var mRO: Double? = null,
    var mUR: Double? = null,
    var mVR: Double? = null,
    var mWK: Double? = null,
    var mXN: Double? = null,
    var mYR: Double? = null,
    var mZN: Double? = null,
    var nAD: Double? = null,
    var nGN: Double? = null,
    var nIO: Double? = null,
    var nOK: Double? = null,
    var nPR: Double? = null,
    var nZD: Double? = null,
    var oMR: Double? = null,
    var pAB: Double? = null,
    var pEN: Double? = null,
    var pGK: Double? = null,
    var pHP: Double? = null,
    var pKR: Double? = null,
    var pLN: Double? = null,
    var pYG: Double? = null,
    var qAR: Double? = null,
    var rON: Double? = null,
    var rSD: Double? = null,
    var rUB: Double? = null,
    var rWF: Double? = null,
    var sAR: Double? = null,
    var sBD: Double? = null,
    var sCR: Double? = null,
    var sDG: Double? = null,
    var sEK: Double? = null,
    var sGD: Double? = null,
    var sHP: Double? = null,
    var sLL: Double? = null,
    var sOS: Double? = null,
    var sRD: Double? = null,
    var sTD: Double? = null,
    var sVC: Double? = null,
    var sYP: Double? = null,
    var sZL: Double? = null,
    var tHB: Double? = null,
    var tJS: Double? = null,
    var tMT: Double? = null,
    var tND: Double? = null,
    var tOP: Double? = null,
    var tRY: Double? = null,
    var tTD: Double? = null,
    var tWD: Double? = null,
    var tZS: Double? = null,
    var uAH: Double? = null,
    var uGX: Double? = null,
    var uSD: Double? = null,
    var uYU: Double? = null,
    var uZS: Double? = null,
    var vEF: Double? = null,
    var vES: Double? = null,
    var vND: Double? = null,
    var vUV: Double? = null,
    var wST: Double? = null,
    var xAF: Double? = null,
    var xAG: Double? = null,
    var xAU: Double? = null,
    var xCD: Double? = null,
    var xDR: Double? = null,
    var xOF: Double? = null,
    var xPF: Double? = null,
    var yER: Double? = null,
    var zAR: Double? = null,
    var zMK: Double? = null,
    var zMW: Double? = null,
    var zWL: Double? = null
)

fun Offline_rates.toModel() = Rates(
    base, date, AED, AFN, ALLL, AMD, ANG, AOA, ARS, AUD, AWG, AZN, BAM, BBD,
    BDT, BGN, BHD, BIF, BMD, BND, BOB, BRL, BSD, BTC, BTN, BWP, BYN, BYR, BZD,
    CAD, CDF, CHF, CLF, CLP, CNY, COP, CRC, CUC, CUP, CVE, CZK, DJF, DKK, DOP,
    DZD, EGP, ERN, ETB, EUR, FJD, FKP, GBP, GEL, GGP, GHS, GIP, GMD, GNF, GTQ,
    GYD, HKD, HNL, HRK, HTG, HUF, IDR, ILS, IMP, INR, IQD, IRR, ISK, JEP, JMD,
    JOD, JPY, KES, KGS, KHR, KMF, KPW, KRW, KWD, KYD, KZT, LAK, LBP, LKR, LRD,
    LSL, LTL, LVL, LYD, MAD, MDL, MGA, MKD, MMK, MNT, MOP, MRO, MUR, MVR, MWK,
    MXN, MYR, MZN, NAD, NGN, NIO, NOK, NPR, NZD, OMR, PAB, PEN, PGK, PHP, PKR,
    PLN, PYG, QAR, RON, RSD, RUB, RWF, SAR, SBD, SCR, SDG, SEK, SGD, SHP, SLL,
    SOS, SRD, STD, SVC, SYP, SZL, THB, TJS, TMT, TND, TOP, TRY, TTD, TWD, TZS,
    UAH, UGX, USD, UYU, UZS, VEF, VES, VND, VUV, WST, XAF, XAG, XAU, XCD, XDR,
    XOF, XPF, YER, ZAR, ZMK, ZMW, ZWL
)
