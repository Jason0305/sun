
function initComplexArea(a, k, h, p, q, d, b, l) {
    const f = initComplexArea.arguments;
    const m = document.getElementById(a);
    const o = document.getElementById(k);
    const n = document.getElementById(h);
    let e = 0;
    let c = 0;
    if (p != undefined) {
        if (d != undefined) {
            d = parseInt(d);f
        }
        else {
            d = 0;
        }
        if (b != undefined) {
            b = parseInt(b);
        }
        else {
            b = 0;
        }
        if (l != undefined) {
            l = parseInt(l);
        }
        else {
            l = 0
        }
        n[0] = new Option("请选择 ", 0);
        for (e = 0; e < p.length; e++) {
            if (p[e] == undefined) {
                continue;
            }
            if (f[6]) {
                if (f[6] == true) {
                    if (e == 0) {
                        continue
                    }
                }
            }
            m[c] = new Option(p[e], e);
            if (d == e) {
                m[c].selected = true;
            }
            c++
        }
        if (q[d] != undefined) {
            c = 0; for (e = 0; e < q[d].length; e++) {
                if (q[d][e] == undefined) { continue }
                if (f[6]) {
                    if ((f[6] == true) && (d != 71) && (d != 81) && (d != 82)) {
                        if ((e % 100) == 0) { continue }
                    }
                } o[c] = new Option(q[d][e], e);
                if (b == e) { o[c].selected = true } c++
            }
        }
    }
}
function changeComplexProvince(f, k, e, d) {
    const c = changeComplexProvince.arguments;
    const h = document.getElementById(e);
    const g = document.getElementById(d);
    let b = 0;
    let a = 0;
    removeOptions(h); f = parseInt(f);
    if (k[f] != undefined) {
        for (b = 0; b < k[f].length; b++) {
            if (k[f][b] == undefined) { continue }
            if (c[3]) { if ((c[3] == true) && (f != 71) && (f != 81) && (f != 82)) { if ((b % 100) == 0) { continue } } }
            h[a] = new Option(k[f][b], b); a++
        }
    }
    removeOptions(g); g[0] = new Option("请选择", 0);
    if (f == 11 || f == 12 || f == 31 || f == 71 || f == 50 || f == 81 || f == 82) {
        if ($("#" + d + "_div"))
        { $("#" + d + "_div").hide(); }
    }
    else {
        if ($("#" + d + "_div")) { $("#" + d + "_div").show(); }
    }
}


function changeCity(c, a, t) {
    $("#" + a).html('<option value="0" >请选择</option>');
    $("#" + a).unbind("change");
    c = parseInt(c);
    const _d = sub_arr[c];
    let str = "";
    str += "<option value='0' >请选择</option>";
    for (let i = c * 100; i < _d.length; i++) {
        if (_d[i] == undefined) continue;
        str += "<option value='" + i + "' >" + _d[i] + "</option>";
    }
    $("#" + a).html(str);

}

function removeOptions(optionDom) {
    if ((optionDom != undefined) && (optionDom.options != undefined)) {
        for (let b = 0; b < optionDom.options.length; b++) {
            optionDom.options[0] = null;
        }
    }
}


