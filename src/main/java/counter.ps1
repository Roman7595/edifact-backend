<#
.SYNOPSIS
.PARAMETER Path
.PARAMETER Filter
#>
param(
    [string]$Path   = ".",
    [string]$Filter = "*"
)

$ErrorActionPreference = "Continue"

[int] $totalLines = 0
$results = @()


Get-ChildItem -Path $Path -Recurse -File -Filter $Filter | ForEach-Object {
    $file = $_
    try {
        $lines = [System.IO.File]::ReadLines($file.FullName).Length.Length
        Write-Host "$lines"
        $totalLines += $lines
        $results += [PSCustomObject]@{
            file  = $file.FullName
            lines = $lines
        }

    } catch {
        Write-Warning "$($file.FullName): $_"
    }
}

# Вывод результатов
if ($results.Count -gt 0) {
    $results | Sort-Object Файл | Format-Table -AutoSize
} else {
}

Write-Host "`n================================================" -ForegroundColor DarkGray
Write-Host "$totalLines" -ForegroundColor Green