On Error Resume Next
Const wdExportFormatPDF = 17
Set oWord = wscript.CreateObject("Word.Application")
Set fso = wscript.CreateObject("Scripting.Filesystemobject")
Set fds = fso.GetFolder(".")
Set ffs = fds.Files
i = 0
For Each ff In ffs
	If (LCase(Right(ff.Name, 4)) = ".doc" Or LCase(Right(ff.Name, 4)) = "docx") And Left(ff.Name, 1) <> "~" Then
		wscript.echo "处理文件：" & ff.Name & " 开始"
		Set oDoc = oWord.Documents.Open(ff.Path)
		oDoc.ExportAsFixedFormat Left(ff.Path, InStrRev(ff.Path, ".")) & "pdf", wdExportFormatPDF
		oDoc.Close
		i = i + 1
		wscript.echo "处理文件：" & ff.Name & " 结束，" & "已完成" & i
		If Err And Err.Number Then
		wscript.echo Err.Description
		End If
	End If
Next
oDoc.Close
oWord.Quit
Set oDoc = Nothing
Set oWord = Nothing
wscript.echo "Word文件已全部轩换为PDF格式!"