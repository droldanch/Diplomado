//
//  ViewController.swift
//  Lifes Adventure
//
//  Created by Daniel Roldan Chavez on 13/02/17.
//  Copyright © 2017 Daniel Roldan Chavez. All rights reserved.
//

import UIKit

class ListViajeController: UICollectionViewController,UICollectionViewDelegateFlowLayout {

    
 /*   var viajes: [Viaje] =
        {
            var KanyeCHannel = Channel()
            KanyeCHannel.name = "Conoce Merida 2"
            
            var bankSpaceViaje = Viaje()
            bankSpaceViaje.title = "Viaje a Yucatan"
            bankSpaceViaje.thubnailImageName = "ejemplo"
            bankSpaceViaje.channel = KanyeCHannel
            bankSpaceViaje.date = "29-06-2017"
            bankSpaceViaje.price = "4,000"
            
            var bankSpaceViaje2 = Viaje()
            bankSpaceViaje2.title = "Viaje a Otro Lugar"
            bankSpaceViaje2.thubnailImageName = "ejemplo"
            bankSpaceViaje2.channel = KanyeCHannel
            bankSpaceViaje2.date = "29-06-2017"
            bankSpaceViaje2.price = "4,000"
            
            var bankSpaceViaje3 = Viaje()
            bankSpaceViaje3.title = "Viaje a Otro Mas"
            bankSpaceViaje3.thubnailImageName = "ejemplo"
            bankSpaceViaje3.channel = KanyeCHannel
            bankSpaceViaje3.date = "29-06-2017"
            bankSpaceViaje3.price = "4,000"

            return [bankSpaceViaje,bankSpaceViaje2,bankSpaceViaje3]
        }()*/
    
    var viajesArray:[Viaje]?
    
    
    func fetchViajes(){
      /*  let url = NSURL(string:"http://104.236.4.172:81/app_dev.php/getEvents")
        
        
        URLSession.shared.dataTask(with: url! as URL) { (data, response, error) in
          
            if error != nil{
            print(error)
                return
            }
            
            let str = NSString(data: data!, encoding: String.Encoding.utf8.rawValue)
            print(str)
            
            
            
        }.resume()*/
        
      //  let mapDict = [ "id":"1", "name":"2"]
        
       // let json = [ "isValid":"1" , "dict": mapDict ] as [String : Any]
     //   let jsonData : NSData = NSKeyedArchiver.archivedData(withRootObject: json) as NSData
        
        
        let url:NSURL = NSURL(string: "http://104.236.4.172:81/app_dev.php/getEvents")!
        let session = URLSession.shared
        
        let request = NSMutableURLRequest(url: url as URL)
        request.httpMethod = "POST"
        
        let data = "data=Hi".data(using: String.Encoding.utf8)
        
        
        let task = session.uploadTask(with: request as URLRequest, from: data, completionHandler:
            {(data,response,error) in
                
                guard let _:NSData = data as NSData?, let _:URLResponse = response, error == nil else {
                    print("error")
                    return
                }
                do{
                let json = try JSONSerialization.jsonObject(with: data!, options: .mutableContainers)
                
                    self.viajesArray = [Viaje]()
                    
                    for dictionaryJson in json as! [[String: AnyObject]]{
                        let viajes =  Viaje()
                        viajes.title = dictionaryJson["name"] as? String
                        viajes.subtitle = dictionaryJson["placeToVisit"] as? String
                        let dateDictionary = dictionaryJson["endDate"] as! [String: AnyObject]
                        viajes.date = dateDictionary["date"] as! String
                        
                        let picturesDictionary = dictionaryJson["pictures"] as! NSMutableArray
               
                        
                        let pictureOneDictionaty = picturesDictionary[0] as! [String: AnyObject]
                        
                         viajes.thubnailImageName = pictureOneDictionaty["url"] as! String
            
                        viajes.price = dictionaryJson["price"] as? String
                        
                        self.viajesArray?.append(viajes)
                    }
                    
                    self.collectionView?.reloadData()
                    
                } catch let jsonError{
                    print(jsonError)
                }
            
        }
        );
        
        task.resume()
        
    }
    
    override func viewDidLoad() {
        super.viewDidLoad()
       
        fetchViajes()
        
        navigationController?.navigationBar.isTranslucent = false
        
        let titleLabel = UILabel(frame: CGRect(x: 0, y: 0, width: view.frame.width - 32, height: view.frame.height))
        titleLabel.text = "Life's Adventure"
        titleLabel.textColor = UIColor.white
        titleLabel.font = UIFont.systemFont(ofSize: 20)
        navigationItem.titleView = titleLabel
        collectionView?.backgroundColor = UIColor(red: 0/255, green: 126/255, blue: 167/255, alpha: 1)
        collectionView?.register(ViajeCell.self, forCellWithReuseIdentifier: "cellId")
        collectionView?.contentInset = UIEdgeInsets(top: 50, left: 0, bottom: 0, right: 0)
        collectionView?.scrollIndicatorInsets = UIEdgeInsets(top: 50, left: 0, bottom: 0, right: 0)
        
        setupMenuBar()
    }
    
    
    let menuBar: MenuBar = {
        let mb = MenuBar()
        return mb
    }()
    
    private func setupMenuBar() {
        view.addSubview(menuBar)
        view.addConstrainsWithFormat(format: "H:|[v0]|",view: menuBar)
        view.addConstrainsWithFormat(format: "V:|[v0(50)]|",view: menuBar)
    }


     //Numero de celdas
    override func collectionView(_ collectionView: UICollectionView, numberOfItemsInSection section: Int) -> Int {
        
        return viajesArray?.count ?? 0
    }

    //Identificar cntenedor celda
    override func collectionView(_ collectionView: UICollectionView, cellForItemAt indexPath: IndexPath) -> UICollectionViewCell {
        let cell = collectionView.dequeueReusableCell(withReuseIdentifier: "cellId", for: indexPath) as! ViajeCell
        
        cell.viaje = viajesArray?[indexPath.item]
        
        return cell
    }
    //Tamaño por celda
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, sizeForItemAt indexPath: IndexPath) -> CGSize {
       // let height = (view.frame.width - 16 - 16) * 9 / 16
        return CGSize(width: view.frame.width, height: 250)
    }
    
    //Division entre celtas
    func collectionView(_ collectionView: UICollectionView, layout collectionViewLayout: UICollectionViewLayout, minimumLineSpacingForSectionAt section: Int) -> CGFloat {
        return 0;
    }
    
}



