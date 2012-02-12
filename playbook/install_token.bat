THIS
java com.qnx.bbt.airpackager.BarAirPackager -cp@{sdk}/lib/EccpressoJDK15ECC.jar;@{sdk}/lib/EccpressoAll.jar;@{sdk}/lib/BarSigner.jar;@{sdk}/lib/BarDeploy.jar;@{sdk}/lib/BarAir.jar;@{sdk}/lib/BarPackager.jar"
-installDebugToken debug.bar
				<arg line="'${user.home}/Research In Motion/'" />
				<arg line="-device @{ip}" />
				<arg line="-password @{password}