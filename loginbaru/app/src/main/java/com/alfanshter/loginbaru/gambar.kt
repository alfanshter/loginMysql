package com.alfanshter.loginbaru

import android.Manifest
import android.content.Context
import android.content.Intent
import android.content.pm.PackageInfo
import android.content.pm.PackageManager
import android.graphics.Bitmap
import android.media.MediaScannerConnection
import android.os.Build
import androidx.appcompat.app.AppCompatActivity
import android.os.Bundle
import android.os.Environment
import android.provider.MediaStore
import com.alfanshter.loginbaru.Model.DataClass
import com.alfanshter.loginbaru.client.ApiClient
import com.alfanshter.loginbaru.client.ApiResponse
import kotlinx.android.synthetic.main.activity_gambar.*
import okhttp3.MediaType
import okhttp3.MultipartBody
import okhttp3.RequestBody
import org.jetbrains.anko.AnkoLogger
import retrofit2.Call
import retrofit2.Callback
import retrofit2.Response
import java.io.ByteArrayOutputStream
import java.io.File
import java.io.FileOutputStream
import java.io.IOException
import java.util.*

class gambar : AppCompatActivity(),AnkoLogger{

    private var CAMERA_PERMISSION = 80
    var imageName = ""
    var imagePath = ""

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContentView(R.layout.activity_gambar)

        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.M) {
            requestPermissions(arrayOf(Manifest.permission.READ_EXTERNAL_STORAGE,Manifest.permission.WRITE_EXTERNAL_STORAGE,Manifest.permission.CAMERA),10)
        }

        upload.setOnClickListener{
            val intent = Intent(MediaStore.ACTION_IMAGE_CAPTURE)
            startActivityForResult(intent, CAMERA_PERMISSION)
        }



    }


    override fun onActivityResult(requestCode: Int, resultCode: Int, data: Intent?) {
        super.onActivityResult(requestCode, resultCode, data)

        if (resultCode == RESULT_CANCELED){
            return
        }
        if (requestCode == 80 && resultCode == RESULT_OK){
            val thumb: Bitmap = data?.extras?.get("data") as Bitmap
            imageName = getFileName()
            imagePath = saveImage(thumb,this,imageName)
            uploadImage(imagePath)
        }
    }
    fun getFileName():String{
        return "${Calendar.getInstance()
            .getTimeInMillis()}.jpg"
    }

    fun uploadImage(imagePath:String){
        val file = File(imagePath)
        val mFile = RequestBody.create(MediaType.parse("image/*"), file)
        val fileToUpload = MultipartBody.Part.createFormData("file", file.name, mFile)
        val filename = RequestBody.create(MediaType.parse("text/plain"), file.name)
        val apiClient:ApiClient = ApiResponse().response()
        apiClient.uploadFile(fileToUpload,filename).
            enqueue(object : Callback<DataClass> {
                override fun onResponse(call: Call<DataClass>, response: Response<DataClass>) {
                    if (response.isSuccessful) {
                        val data = response.body()

                    }
                }
                override fun onFailure(call: Call<DataClass>, error: Throwable) {

                }
            })
    }

    fun saveImage(myBitmap: Bitmap, context: Context?, nameFile:String): String {
        var imagePath:String = ""
        val m = context?.getPackageManager()
        var s = context?.getPackageName()
        var p: PackageInfo? = null
        try {
            p = m?.getPackageInfo(s, 0)
        } catch (e: PackageManager.NameNotFoundException) {
            e.printStackTrace()
        }

        s = p?.applicationInfo?.dataDir
        val bytes = ByteArrayOutputStream()
        myBitmap.compress(Bitmap.CompressFormat.JPEG, 90, bytes)
        val wallpaperDirectory = File("${Environment.getExternalStorageDirectory()}$s")
        // have the object build the directory structure, if needed.
        if (!wallpaperDirectory.exists()) {
            wallpaperDirectory.mkdirs()
        }

        try {
            var f = File(wallpaperDirectory, nameFile)
            f.createNewFile()
            val fo = FileOutputStream(f)
            fo.write(bytes.toByteArray())
            MediaScannerConnection.scanFile(context,
                arrayOf(f.getPath()),
                arrayOf("image/jpeg"), null)
            fo.close()
            f = File(f.getAbsolutePath())
            return f.getAbsolutePath()
        } catch (e1: IOException) {
            e1.printStackTrace()
        }

        return imagePath
    }


}
