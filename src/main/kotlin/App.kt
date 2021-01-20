import java.util.*
import org.apache.commons.lang3.StringUtils
import java.text.SimpleDateFormat

var dotMatrix = 30

fun main(){
    //input
    print("Masukan nama warung: ")
    val input2 = Scanner(System.`in`)
    val namaWarung:String = input2.nextLine()
    print("Masukan nama kasir: ")
    val input3 = Scanner(System.`in`)
    val namaKasir:String = input3.nextLine()
    println("Masukan data makanan jika sudah ketik selesai")

    val input = Scanner(System.`in`)
    val input1 = Scanner(System.`in`)
    var inputLength = 999
    val listMenu = ArrayList<Produk>()
    for (i in 1..inputLength) {
        val produk = Produk()
        print("Masukan nama makanan: ")
        produk.nama = input.nextLine()
        if (produk.nama == "selesai") break
        print("Masukan harga makanan: ")
        produk.harga = input1.nextInt()

        listMenu.add(produk)
    }

    println()

    //output
    var printNamaWarung = StringUtils.center(StringUtils.center(namaWarung, dotMatrix), dotMatrix)
    var sisa = printNamaWarung.length- dotMatrix
    if (printNamaWarung.length > 30) {
        printNamaWarung = StringUtils.left(printNamaWarung, printNamaWarung.length - (printNamaWarung.length-dotMatrix))
    }
    println(printNamaWarung)
    val printSisanya = StringUtils.center(StringUtils.center(StringUtils.right(printNamaWarung, sisa), dotMatrix), dotMatrix)
    if (printNamaWarung.length > 30) {
        println(printSisanya)
    }


    println()

    val sdf = SimpleDateFormat("yyyy/M/dd hh:mm:ss")
    val tanggalSekarang = sdf.format(Date())
    println(StringUtils.rightPad("Tanggal : ", dotMatrix - tanggalSekarang.length, " ") + tanggalSekarang)

    println(StringUtils.rightPad("Nama Kasir : ", dotMatrix - namaKasir.length, " ") + namaKasir)
    for (i in 1..30) {
        print("=")
    }

    println()

    for (printMenu in listMenu) {
        print(printMenu.nama)
        for (i in 1..dotMatrix-printMenu.nama.length-printMenu.harga.toString().length-3) {
            print(".")
        }
        println("Rp." + printMenu.harga)
    }
    var totalHarga = 0
    for (harga in listMenu) {
        totalHarga += harga.harga
    }

    println()
    println(StringUtils.rightPad("Total Harga", dotMatrix - totalHarga.toString().length - 3, ".") + "Rp.$totalHarga")

}

